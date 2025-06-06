package sh.miles.voidcr.impl.plugin;

import sh.miles.voidcr.plugin.exception.PluginLoadException;
import sh.miles.voidcr.plugin.meta.PluginDependency;
import sh.miles.voidcr.plugin.meta.PluginMeta;
import sh.miles.voidcr.util.graph.UniqueGraphNode;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public final class PluginLoadGraph {

    private final Set<UniqueGraphNode<PluginMeta>> nodes;

    public PluginLoadGraph(int expectedMaximumSize) {
        this.nodes = new LinkedHashSet<>(expectedMaximumSize);
    }

    public List<PluginMeta> generate(Map<String, PluginMeta> plugins) throws IllegalStateException, PluginLoadException {
        if (!this.nodes.isEmpty()) {
            this.nodes.clear();
        }

        for (final PluginMeta value : plugins.values()) {
            insert(new UniqueGraphNode<>(value), plugins);
        }

        if (this.nodes.size() != plugins.size()) {
            throw new IllegalStateException("Can not generate load order because inserted nodes is not similarly sized to plugins expected size of %d but found size of %d".formatted(this.nodes.size(), plugins.size()));
        }

        return nodes.stream()
                .flatMap((UniqueGraphNode<PluginMeta> node) -> node.collectRelatives().stream())
                .distinct()
                .map(UniqueGraphNode::getValue)
                .collect(Collectors.toList());
    }

    private void insert(UniqueGraphNode<PluginMeta> inserting, Map<String, PluginMeta> plugins) throws PluginLoadException {
        final PluginMeta meta = inserting.getValue();
        if (nodes.contains(inserting)) {
            return;
        }
        this.nodes.add(inserting);

        for (final PluginDependency dependency : meta.dependencies()) {
            UniqueGraphNode<PluginMeta> depNode = findDependency(dependency.name());
            if (depNode == null) {
                final var temp = plugins.get(dependency.name());
                if (temp == null && dependency.required()) {
                    throw new PluginLoadException("Can not load %s because %s is not present and it is a required dependency".formatted(meta.name(), dependency.name()));
                }
                depNode = new UniqueGraphNode<>(temp);
            }

            if (dependency.loadBefore()) {
                inserting.child(depNode);
            } else depNode.child(inserting);

            if (!nodes.contains(depNode)) {
                insert(depNode, plugins);
            }

            if (inserting.hasChild(depNode) && depNode.hasChild(inserting)) {
                throw new PluginLoadException("Can not load %s because it has a circular dependency with %s".formatted(meta.name(), dependency.name()));
            }
        }
    }


    private UniqueGraphNode<PluginMeta> findDependency(String depName) {
        for (final UniqueGraphNode<PluginMeta> node : nodes) {
            if (node.getValue().name().equals(depName)) {
                return node;
            }
        }

        return null;
    }

}

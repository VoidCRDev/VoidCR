package sh.miles.voidcr.testplugin;

import org.jspecify.annotations.NullMarked;
import sh.miles.voidcr.entity.PlayerEntity;
import sh.miles.voidcr.plugin.lifecycle.event.world.block.pre.PrePlayerInteractBlockEvent;
import sh.miles.voidcr.plugin.lifecycle.event.world.inventory.container.pre.PrePlayerItemContainerInteractEvent;
import sh.miles.voidcr.plugin.type.StandardPlugin;
import sh.miles.voidcr.server.Server;
import sh.miles.voidcr.types.BlockTypes;
import sh.miles.voidcr.world.block.BlockType;
import sh.miles.voidcr.world.position.Position;

@NullMarked
public class TestStandardPlugin implements StandardPlugin {

    @Override
    public void initialize(final Server server) {
        server.getLifecycle().observe(this, PrePlayerItemContainerInteractEvent.class, (event, id) -> {
            System.out.println(event.getInteraction());
        });
        server.getLogger().info("Hello, World! From Test Plugin!");
    }

    @Override
    public void disable(final Server server) {
        server.getLogger().info("Goodbye, World! From Test Plugin!");
    }
}

package sh.miles.voidcr.testplugin;

import org.jspecify.annotations.NullMarked;
import sh.miles.voidcr.entity.EntityType;
import sh.miles.voidcr.entity.PlayerEntity;
import sh.miles.voidcr.plugin.type.StandardPlugin;
import sh.miles.voidcr.server.Server;
import sh.miles.voidcr.server.registry.Registries;
import sh.miles.voidcr.util.NamedKey;

@NullMarked
public class TestStandardPlugin implements StandardPlugin {

    @Override
    public void initialize(final Server server) {
        server.getLogger().info("Hello, World! From Test Plugin!");
        server.getLifecycle().registerArgumentResolver(this, EntityType.class, (string) -> Registries.ENTITY.get(NamedKey.key(string)));

        server.getLifecycle().registerCommand(this, (builder) -> {
            builder.name("summon")
                    .executor(((executor, context) -> {
                        final EntityType type = context.getArgumentOrElse(0, EntityType.class, null);
                        if (type == null) {
                            executor.sendMessage("No such entity type " + context.getArgument(0));
                            return;
                        }

                        if (!(executor instanceof PlayerEntity player)) {
                            executor.sendMessage("Non players can't execute this command");
                            return;
                        }

                        player.getWorld().summonEntity(type, player.getPosition(), (e) -> {
                            e.setHealth(0.1f);
                        });
                    }))
                    .yieldOnConflict(false)
                    .description("Summons mobs")
                    .preferSourceForTypes(this, EntityType.class);
        });
    }

    @Override
    public void disable(final Server server) {
        server.getLogger().info("Goodbye, World! From Test Plugin!");
    }
}

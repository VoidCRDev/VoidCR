package sh.miles.voidcr.impl.server.registry;

import finalforeach.cosmicreach.blocks.Block;
import finalforeach.cosmicreach.items.ItemThing;
import finalforeach.cosmicreach.networking.packets.items.SlotInteractionType;
import finalforeach.cosmicreach.particles.GameParticleSystem;
import sh.miles.voidcr.impl.util.collection.VoidRegistry;
import sh.miles.voidcr.impl.world.block.VoidBlockType;
import sh.miles.voidcr.impl.world.inventory.container.VoidItemContainerInteraction;
import sh.miles.voidcr.impl.world.inventory.item.VoidItemProperties;
import sh.miles.voidcr.impl.world.inventory.item.VoidItemType;
import sh.miles.voidcr.impl.world.particle.VoidParticleType;
import sh.miles.voidcr.server.registry.Registries;
import sh.miles.voidcr.world.block.BlockType;
import sh.miles.voidcr.world.inventory.container.ItemContainerInteraction;
import sh.miles.voidcr.world.inventory.item.ItemProperty;
import sh.miles.voidcr.world.inventory.item.ItemType;
import sh.miles.voidcr.world.particle.ParticleType;

public final class VoidRegistries implements Registries {

    public static <V> VoidRegistry<?, ?> createRegistry(Class<V> apiClass) {
        if (apiClass == BlockType.class) {
            return VoidNamedRegistry.fromNaiveInternalSource(Block.blocksByStringId.values(), VoidBlockType::new);
        }

        if (apiClass == ItemType.class) {
            return VoidNamedRegistry.fromGdxNaiveInternalSource(ItemThing.allItems.values().toArray(), VoidItemType::new);
        }

        if (apiClass == ItemContainerInteraction.class) {
            return VoidNamedRegistry.fromEnumSource(SlotInteractionType.class, VoidItemContainerInteraction::new);
        }

        if (apiClass == ItemProperty.class) {
            return VoidNamedRegistry.fromArraySource(VoidItemProperties.KEYS, VoidItemProperties::create);
        }

        if (apiClass == ParticleType.class) {
            return VoidNamedRegistry.fromArraySource(new GameParticleSystem[]{
                    GameParticleSystem.explosionParticleSystem,
                    GameParticleSystem.flameParticleSystem,
                    GameParticleSystem.jetpackParticleSystem,
                    GameParticleSystem.laserParticleSystem
            }, VoidParticleType::new);
        }

        throw new IllegalArgumentException("No known registry for type " + apiClass.getName());
    }
}

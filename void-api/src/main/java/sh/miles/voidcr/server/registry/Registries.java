package sh.miles.voidcr.server.registry;

import sh.miles.voidcr.server.VoidCR;
import sh.miles.voidcr.util.Keyed;
import sh.miles.voidcr.util.NamedKey;
import sh.miles.voidcr.util.collection.KeyHolder;
import sh.miles.voidcr.util.collection.Registry;
import sh.miles.voidcr.world.block.BlockType;
import sh.miles.voidcr.world.inventory.container.ItemContainerInteraction;
import sh.miles.voidcr.world.inventory.item.ItemProperty;
import sh.miles.voidcr.world.inventory.item.ItemType;
import sh.miles.voidcr.world.particle.ParticleType;

/**
 * Access for registries
 *
 * @since 0.3.14
 */
public interface Registries {

    /**
     * The Block Type registry, does not support registration
     *
     * @since 0.3.14
     */
    NamedRegistry<BlockType> BLOCK = namedRegistry(BlockType.class);

    /**
     * The Item Type registry, does not support registration
     *
     * @since 0.3.22
     */
    NamedRegistry<ItemType> ITEM = namedRegistry(ItemType.class);

    /**
     * The Particle Type Registry, does not support registration
     * <p>
     * Internally represented as a list of fields so after updates particle types may be missing this is always an
     * issue. All keys for this registry are under {@link NamedKey#COSMIC_REACH} due to them being internally modeled,
     * but no in this form.
     *
     * @since 0.4.15
     */
    NamedRegistry<ParticleType> PARTICLE = namedRegistry(ParticleType.class);

    /**
     * The ItemContainerInteraction registry, does not support registration
     * <p>
     * Item Container Interactions are internally modeled as an enum, in order to maintain the longevity of this API
     * they are instead modeled as a registry here. All keys for this registry are under {@link NamedKey#COSMIC_REACH}
     * due to them being internally modeled, but not in this form.
     *
     * @since 0.4.1
     */
    NamedRegistry<ItemContainerInteraction> ITEM_CONTAINER_INTERACT = namedRegistry(ItemContainerInteraction.class);

    /**
     * The Item Property registry, does not support registration
     * <p>
     * Item Properties themselves are not a concept internally, thus this registry is the invention of VoidCR itself,
     * the long term stability is based off of a likely stable and somewhat flexible API design, however it is possible
     * this Registry might be deprecated in the future. All keys for this registry are under the
     * {@link NamedKey#VOID_CR} namespace.
     *
     * @since 0.3.23
     */
    NamedRegistry<ItemProperty> ITEM_PROPERTY = namedRegistry(ItemProperty.class);


    private static <E extends Keyed> NamedRegistry<E> namedRegistry(Class<E> clazz) {
        return (NamedRegistry<E>) VoidCR.getMagic().getRegistry(clazz);
    }

    private static <E extends KeyHolder<K>, K> Registry<E, K> registry(Class<E> clazz) {
        return VoidCR.getMagic().getRegistry(clazz);
    }

}

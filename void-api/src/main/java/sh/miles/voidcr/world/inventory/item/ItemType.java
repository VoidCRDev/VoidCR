package sh.miles.voidcr.world.inventory.item;

import sh.miles.voidcr.server.registry.Registries;
import sh.miles.voidcr.util.Keyed;
import sh.miles.voidcr.util.NamedKey;
import sh.miles.voidcr.world.block.BlockState;
import sh.miles.voidcr.world.block.BlockType;

/**
 * Represents a type Item that can be in a container
 * <p>
 * This class only contains static entries of only pure items. BlockType's and their equivalent items can be found at
 * {@link BlockType} by using {@link BlockType#getAllBlockStates()} and fetching items via
 * {@link BlockState#getItemType()}. Because this is such an odd structure this is likely subject to change in the
 * future, with a large prior notice.
 *
 * @since 0.3.22
 */
public interface ItemType extends Keyed {

    /**
     * Gets the maximum stack size of this item type
     *
     * @return the maximum stack size
     * @since 0.3.22
     */
    int getMaxStackSize();

    /**
     * Gets whether or not the given item type is within the creative catalog
     *
     * @return true if in the catalog, otherwise false
     * @since 0.3.22
     */
    boolean isInCatalog();

    /**
     * Utility helper for a cast to {@link #key()}
     * <p>
     * ItemKeys are generally more permissible than {@link NamedKey}
     *
     * @return the item key
     * @since 0.3.23
     */
    ItemKey getItemKey();

    private static ItemType item(String key) {
        return Registries.ITEM.get(ItemKey.cosmicReach(key));
    }
}

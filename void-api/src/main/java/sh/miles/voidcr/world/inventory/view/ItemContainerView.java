package sh.miles.voidcr.world.inventory.view;

import sh.miles.voidcr.entity.PlayerEntity;
import sh.miles.voidcr.world.inventory.container.ItemContainer;

/**
 * Represents a view of a {@link ItemContainer}
 *
 * @since 0.4.1
 */
public interface ItemContainerView {
    /**
     * Gets the item container for this view
     *
     * @return the item container
     * @since 0.4.1
     */
    ItemContainer getItemContainer();

    /**
     * Gets the viewer in this view
     *
     * @return the viewer
     * @since 0.4.1
     */
    PlayerEntity getViewer();
}

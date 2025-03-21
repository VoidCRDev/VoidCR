package sh.miles.voidcr.plugin.lifecycle.event.world.inventory.container;

import sh.miles.voidcr.world.inventory.container.ItemContainer;

/**
 * A generic event for all events surrounding ItemContainers
 *
 * @since 0.4.1
 */
public interface ItemContainerEvent {

    /**
     * Gets the ItemContainer related to this event
     *
     * @return the item container
     * @since 0.4.1
     */
    ItemContainer getItemContainer();
}

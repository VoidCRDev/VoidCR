package sh.miles.voidcr.plugin.lifecycle.event.world.inventory.container;

import sh.miles.voidcr.entity.PlayerEntity;
import sh.miles.voidcr.world.inventory.container.ItemContainerInteraction;
import sh.miles.voidcr.world.inventory.item.ItemStack;

/**
 * Event triggered when a player interacts with an ItemContainer
 *
 * @since 0.4.1
 */
public interface PlayerItemContainerInteractEvent extends ItemContainerEvent {

    /**
     * Gets the item that was interacted with, air for empty
     *
     * @return the item
     * @since 0.4.4
     */
    ItemStack getItem();

    /**
     * Get slot that was interacted with
     *
     * @return the interacted slot
     * @since 0.4.1
     */
    int getSlot();

    /**
     * Gets the player who interacted with the container
     *
     * @return the player
     * @since 0.4.1
     */
    PlayerEntity getPlayer();

    /**
     * Gets the interaction that occurred
     *
     * @return the interaction
     * @since 0.4.1
     */
    ItemContainerInteraction getInteraction();
}

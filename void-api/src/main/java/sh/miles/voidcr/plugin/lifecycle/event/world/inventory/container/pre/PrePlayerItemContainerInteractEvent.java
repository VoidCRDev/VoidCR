package sh.miles.voidcr.plugin.lifecycle.event.world.inventory.container.pre;

import sh.miles.voidcr.plugin.lifecycle.Cancelable;
import sh.miles.voidcr.plugin.lifecycle.event.LifecycleEvent;
import sh.miles.voidcr.plugin.lifecycle.event.world.inventory.container.PlayerItemContainerInteractEvent;
import sh.miles.voidcr.server.Server;
import sh.miles.voidcr.world.inventory.item.ItemStack;

/**
 * Event triggered before a item container interaction occurs
 *
 * @since 0.4.1
 */
public interface PrePlayerItemContainerInteractEvent extends PlayerItemContainerInteractEvent, Cancelable, LifecycleEvent<Server> {

    /**
     * Sets the item of the interaction
     *
     * @param item the item
     * @since 0.4.1
     */
    void setItem(ItemStack item);
}

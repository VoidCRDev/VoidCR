package sh.miles.voidcr.plugin.lifecycle.event.world.inventory.container.post;

import sh.miles.voidcr.plugin.lifecycle.event.LifecycleEvent;
import sh.miles.voidcr.plugin.lifecycle.event.world.inventory.container.PlayerItemContainerInteractEvent;
import sh.miles.voidcr.server.Server;

public interface PostPlayerItemContainerInteractEvent extends PlayerItemContainerInteractEvent, LifecycleEvent<Server> {
}

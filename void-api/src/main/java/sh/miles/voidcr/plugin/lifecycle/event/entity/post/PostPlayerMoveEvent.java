package sh.miles.voidcr.plugin.lifecycle.event.entity.post;

import sh.miles.voidcr.plugin.lifecycle.event.LifecycleEvent;
import sh.miles.voidcr.plugin.lifecycle.event.entity.PlayerMoveEvent;
import sh.miles.voidcr.server.Server;

/**
 * Represents an event that occurs after a player moves. This interface extends PlayerMoveEvent and is used for actions
 * that should happen after an player has completed its move.
 *
 * @since 0.4.15
 */
public interface PostPlayerMoveEvent extends PlayerMoveEvent, LifecycleEvent<Server> {
}

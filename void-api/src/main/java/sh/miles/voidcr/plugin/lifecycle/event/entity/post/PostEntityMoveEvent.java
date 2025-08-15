package sh.miles.voidcr.plugin.lifecycle.event.entity.post;

import sh.miles.voidcr.plugin.lifecycle.event.LifecycleEvent;
import sh.miles.voidcr.plugin.lifecycle.event.entity.EntityMoveEvent;
import sh.miles.voidcr.server.Server;

/**
 * Represents an event that occurs after an entity moves. This interface extends EntityMoveEvent and is used for actions
 * that should happen after an entity has completed its move.
 *
 * @since 0.4.15
 */
public interface PostEntityMoveEvent extends EntityMoveEvent, LifecycleEvent<Server> {
}

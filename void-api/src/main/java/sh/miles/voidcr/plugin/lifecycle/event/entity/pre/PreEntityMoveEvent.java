package sh.miles.voidcr.plugin.lifecycle.event.entity.pre;

import sh.miles.voidcr.plugin.lifecycle.event.LifecycleEvent;
import sh.miles.voidcr.plugin.lifecycle.event.entity.EntityMoveEvent;
import sh.miles.voidcr.server.Server;
import sh.miles.voidcr.world.position.Position;

/**
 * Represents an event that occurs before an entity moves. This interface extends EntityMoveEvent and adds methods to
 * modify the move parameters. Plugins can implement this interface to modify the movement behavior of entities.
 *
 * @since 0.4.15
 */
public interface PreEntityMoveEvent extends EntityMoveEvent, LifecycleEvent<Server> {

    /**
     * Sets a new destination position for the entity's move. This method allows plugins to change where the entity will
     * move to.
     *
     * @param position The new destination position
     * @since 0.4.15
     */
    void setTo(Position position);

    /**
     * Sets a new starting position for the entity's move. This method allows plugins to change where the entity will
     * start moving from.
     *
     * @param position The new starting position
     * @since 0.4.15
     */
    void setFrom(Position position);
}

package sh.miles.voidcr.plugin.lifecycle.event.entity;

import sh.miles.voidcr.world.position.Position;

/**
 * Represents an event that occurs when an entity moves. This interface provides methods to get the starting and ending
 * positions of the move, as well as whether the entity is on the ground during the move.
 *
 * @since 0.4.15
 */
public interface EntityMoveEvent extends EntityEvent {

    /**
     * Gets the position where the entity started moving from.
     *
     * @return The starting position of the move
     * @since 0.4.15
     */
    Position getFrom();

    /**
     * Gets the position where the entity is moving to.
     *
     * @return The destination position of the move
     * @since 0.4.15
     */
    Position getTo();

    /**
     * Checks if the entity is on the ground during the move.
     *
     * @return true if the entity is on the ground, false otherwise
     * @since 0.4.15
     */
    boolean isOnGround();
}

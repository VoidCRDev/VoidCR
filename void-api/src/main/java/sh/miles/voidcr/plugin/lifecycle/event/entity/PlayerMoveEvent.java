package sh.miles.voidcr.plugin.lifecycle.event.entity;

import sh.miles.voidcr.entity.PlayerEntity;
import sh.miles.voidcr.world.position.Vector;

/**
 * Represents an event that occurs when a player moves. This interface provides methods to get the starting and ending
 * positions of the move, as well as whether the player is on the ground and other attributes during the move.
 *
 * @since 0.4.15
 */
public interface PlayerMoveEvent extends EntityMoveEvent {
    /**
     * Returns the direction the player is looking.
     *
     * @return The view direction as a Vector
     * @since 0.4.15
     */
    Vector getViewDirection();

    /**
     * Returns the offset position of the player's view.
     *
     * @return The view position offset as a Vector
     * @since 0.4.15
     */
    Vector getViewPositionOffset();

    /**
     * Checks if the player is sneaking.
     *
     * @return true if the player is sneaking, false otherwise
     * @since 0.4.15
     */
    boolean isSneaking();

    /**
     * Checks if the player is sprinting.
     *
     * @return true if the player is sprinting, false otherwise
     * @since 0.4.15
     */
    boolean isSprinting();

    /**
     * Checks if the player is prone.
     *
     * @return true if the player is prone, false otherwise
     * @since 0.4.15
     */
    boolean isProne();

    /**
     * Returns the player entity associated with this event.
     *
     * @return The player entity
     * @since 0.4.15
     */
    PlayerEntity getPlayer();
}

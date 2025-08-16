package sh.miles.voidcr.plugin.lifecycle.event.entity.pre;

import sh.miles.voidcr.plugin.lifecycle.event.LifecycleEvent;
import sh.miles.voidcr.plugin.lifecycle.event.entity.PlayerMoveEvent;
import sh.miles.voidcr.server.Server;
import sh.miles.voidcr.world.position.Vector;

/**
 * Represents an event that occurs before a player moves. This interface extends PlayerMoveEvent and adds methods to
 * modify the move parameters. Plugins can implement this interface to modify the movement behavior of players.
 *
 * @since 0.4.15
 */
public interface PrePlayerMoveEvent extends PlayerMoveEvent, LifecycleEvent<Server> {
    /**
     * Sets the direction the player is looking.
     *
     * @param viewDirection The new view direction
     * @since 0.4.15
     */
    void setViewDirection(Vector viewDirection);

    /**
     * Sets the offset position of the player's view.
     *
     * @param viewDirectionOffset The new view position offset
     * @since 0.4.15
     */
    void setViewPositionOffset(Vector viewDirectionOffset);

    /**
     * Sets whether the player is sneaking.
     *
     * @param sneaking true if the player should be sneaking, false otherwise
     * @since 0.4.15
     */
    void setSneaking(boolean sneaking);

    /**
     * Sets whether the player is sprinting.
     *
     * @param sprinting true if the player should be sprinting, false otherwise
     * @since 0.4.15
     */
    void setSprinting(boolean sprinting);

    /**
     * Sets whether the player is prone.
     *
     * @param prone true if the player should be prone, false otherwise
     * @since 0.4.15
     */
    void setProne(boolean prone);
}

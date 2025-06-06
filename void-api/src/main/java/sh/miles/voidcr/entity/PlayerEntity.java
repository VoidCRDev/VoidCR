package sh.miles.voidcr.entity;

import sh.miles.voidcr.chat.Messageable;
import sh.miles.voidcr.server.network.Account;
import sh.miles.voidcr.world.World;
import sh.miles.voidcr.world.inventory.container.ItemContainer;
import sh.miles.voidcr.world.inventory.container.ItemContainerOwner;

/**
 * Represents a player
 *
 * @since 0.3.22
 */
public interface PlayerEntity extends Entity, Messageable, ItemContainerOwner {

    /**
     * Gets the account of this player
     *
     * @return the player's account
     * @since 0.4.1
     */
    Account getAccount();

    /**
     * Gets the player's inventory
     * <p>
     * This method is simply an alias for {@link ItemContainerOwner#getItemContainer()}
     *
     * @return an ItemContainer containing inventory contents
     * @since 0.3.24
     */
    ItemContainer getInventory();

    /**
     * Respawns the player in their current world
     *
     * @since 0.3.22
     */
    void respawn();

    /**
     * Gets the world the player is in
     *
     * @return the world the player is in
     * @since 0.3.22
     */
    World getWorld();

    /**
     * Gets whether or not the player is sprinting
     *
     * @return true if sprinting, otherwise false
     * @since 0.3.22
     */
    boolean isSprinting();

    /**
     * Gets whether or not the player is prone
     *
     * @return true if the player is prone, otherwise false
     * @since 0.3.22
     */
    boolean isProne();

    /**
     * Gets whether or not the player is dead
     *
     * @return true if the player is dead
     * @since 0.3.22
     */
    boolean isDead();

    /**
     * Determines whether or not the given player is an operator
     *
     * @return true if the player is an operator
     * @since 0.3.27
     */
    boolean isOperator();

    /**
     * Gets the user's display name
     *
     * @return the display name
     * @since 0.3.22
     */
    String getDisplayName();
}

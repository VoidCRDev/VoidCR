package sh.miles.voidcr.entity;

import sh.miles.voidcr.plugin.lifecycle.event.entity.pre.PreEntityDamageEvent;
import sh.miles.voidcr.world.World;
import sh.miles.voidcr.world.damage.DamageSource;
import sh.miles.voidcr.world.position.Position;
import sh.miles.voidcr.world.position.Vector;

/**
 * Represents an entity within CosmicReach
 *
 * @since 0.3.14
 */
public interface Entity extends DamageSource {

    /**
     * Teleports this entity to some position
     *
     * @param world the world to teleport the entity within
     * @param to    the to position
     * @since 0.3.27
     */
    void teleport(World world, Position to);

    /**
     * Teleports this entity to some position
     *
     * @param to the to position
     * @since 0.3.27
     */
    void teleport(Position to);

    /**
     * Gets the maximum amount of invulnerability frames after hit
     *
     * @return the maximum amount of invulnerability frames
     * @since 0.3.23
     */
    int getMaximumInvulnerabilityFrames();

    /**
     * Sets the amount of frames applied after being hit
     * <p>
     * Note the effects of this method can be overridden by {@link PreEntityDamageEvent}
     *
     * @param frames the frames to apply after being hit, which must be above or equal to zero
     * @since 0.3.23
     */
    void setMaximumInvulnerabilityFrames(int frames);

    /**
     * Gets the range of sight for this entity
     *
     * @return the range of sight
     * @since 0.3.14
     */
    float getRangeOfSight();

    /**
     * Gets the current health of this entity
     *
     * @return the current health
     * @since 0.3.14
     */
    float getHealth();

    /**
     * Sets the current health of this entity
     *
     * @param health the health, which must be above or equal to zero
     * @since 0.3.23
     */
    void setHealth(float health);

    /**
     * Gets the maximum possible health of this entity
     *
     * @return the maximum possible health of this entity
     * @since 0.3.14
     */
    float getMaxHealth();

    /**
     * Sets the maximum possible health of this entity
     *
     * @param health the maximum health of this entity, which must be above zero
     * @since 0.3.23
     */
    void setMaxHealth(float health);

    /**
     * Gets the current world of this entity
     *
     * @return the world
     * @since 0.3.27
     */
    World getWorld();

    /**
     * Gets the current position of this entity
     *
     * @return this entity's current position
     * @since 0.3.26
     */
    Position getPosition();

    /**
     * Gets the current velocity of this entity
     *
     * @return the entity's current velocity
     * @since 0.3.27
     */
    Vector getVelocity();

    /**
     * An Entity Identifier is much like a UUID, where it is used to identify a specific entity
     *
     * @return the identifier for this entity
     * @since 0.3.14
     */
    EntityIdentifier getIdentifier();
}

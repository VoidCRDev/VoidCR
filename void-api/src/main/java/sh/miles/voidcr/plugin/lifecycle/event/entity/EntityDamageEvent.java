package sh.miles.voidcr.plugin.lifecycle.event.entity;

import org.jspecify.annotations.Nullable;
import sh.miles.voidcr.entity.Entity;
import sh.miles.voidcr.world.damage.DamageSource;

/**
 * An interface modeling base data required for an entity damage event
 *
 * @since 0.3.23
 */
public interface EntityDamageEvent extends EntityEvent {

    /**
     * Gets the amount of invulnerability frames to be applied after the event
     *
     * @return the amount of invulnerability frames applied
     * @since 0.3.22
     */
    int getInvulnerabilityFrames();

    /**
     * Gets the amount of damage done during this event
     *
     * @return the damage amount
     * @since 0.3.22
     */
    float getDamage();

    /**
     * Gets the targeted entity
     *
     * @return the targeted entity
     * @since 0.3.22
     * @deprecated now any {@link DamageSource} can trigger this event for removal in 3 versions
     */
    @Deprecated(since = "0.4.4", forRemoval = true)
    @Nullable
    Entity getDamager();

    /**
     * Gets the damage source of this event, which could be an entity. see {@link DamageSource} for more information
     *
     * @return the damage source
     * @since 0.4.4
     */
    DamageSource getDamageSource();

}

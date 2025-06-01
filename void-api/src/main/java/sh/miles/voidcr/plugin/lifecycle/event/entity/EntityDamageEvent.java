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
     * Gets the damage source of this event, which could be an entity. see {@link DamageSource} for more information
     *
     * @return the damage source
     * @since 0.4.4
     */
    DamageSource getDamageSource();

}

package sh.miles.voidcr.world.damage;

import sh.miles.voidcr.entity.Entity;

/**
 * Represents a source of damage
 * <p>
 * As of now this interface is purely meant to be casted to another interface like {@link Entity}. There may be some
 * cases in which this cast fails. In these cases assume an "environmental" damage source is sent. These can not be
 * represented in API and have no such data to be exposed by
 *
 * @since 0.4.4
 */
public interface DamageSource {
}

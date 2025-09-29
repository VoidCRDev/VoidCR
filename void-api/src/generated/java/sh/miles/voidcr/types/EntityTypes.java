package sh.miles.voidcr.types;

import java.lang.String;
import sh.miles.voidcr.entity.EntityType;
import sh.miles.voidcr.server.registry.Registries;
import sh.miles.voidcr.util.NamedKey;

/**
 * Generated class containing all default {@link EntityType}
 */
public interface EntityTypes {
    /**
     * Generated {@link EntityType} with the id "base:entity_incinerator"
     */
    EntityType ENTITY_INCINERATOR = get("entity_incinerator");

    /**
     * Generated {@link EntityType} with the id "base:entity_planteater"
     */
    EntityType ENTITY_PLANTEATER = get("entity_planteater");

    /**
     * Generated {@link EntityType} with the id "base:entity_drone_trap_interceptor"
     */
    EntityType ENTITY_DRONE_TRAP_INTERCEPTOR = get("entity_drone_trap_interceptor");

    /**
     * Generated {@link EntityType} with the id "base:laser_projectile"
     */
    EntityType LASER_PROJECTILE = get("laser_projectile");

    /**
     * Generated {@link EntityType} with the id "base:falling_block"
     */
    EntityType FALLING_BLOCK = get("falling_block");

    /**
     * Generated {@link EntityType} with the id "base:flame_projectile"
     */
    EntityType FLAME_PROJECTILE = get("flame_projectile");

    /**
     * Generated {@link EntityType} with the id "base:entity_drone_interceptor"
     */
    EntityType ENTITY_DRONE_INTERCEPTOR = get("entity_drone_interceptor");

    /**
     * Generated {@link EntityType} with the id "base:entity_drone_laser"
     */
    EntityType ENTITY_DRONE_LASER = get("entity_drone_laser");

    /**
     * Generated {@link EntityType} with the id "base:entity_item"
     */
    EntityType ENTITY_ITEM = get("entity_item");

    /**
     * Generated {@link EntityType} with the id "base:bullet_projectile"
     */
    EntityType BULLET_PROJECTILE = get("bullet_projectile");

    private static EntityType get(String key) {
        return Registries.ENTITY.get(NamedKey.cosmicReach(key));
    }
}

package sh.miles.voidcr.types;

import sh.miles.voidcr.server.registry.Registries;
import sh.miles.voidcr.util.NamedKey;
import sh.miles.voidcr.world.particle.ParticleType;

public interface ParticleTypes {

    /**
     * Hand Written {@link ParticleType} with the id "base:particles_explosion"
     */
    ParticleType EXPLOSION = get("particles_explosion");

    /**
     * Hand Written {@link ParticleType} with the id "base:particles_laser_projectile"
     */
    ParticleType LASER_PROJECTILE = get("particles_laser_projectile");

    /**
     * Hand Written {@link ParticleType} with the id "base:particles_flame_projectile"
     */
    ParticleType FLAME_PROJECTILE = get("flame_projectile");

    /**
     * Hand Written {@link ParticleType} with the id "base:particles_jetpack"
     */
    ParticleType JETPACK = get("particles_jetpack");


    private static ParticleType get(String key) {
        return Registries.PARTICLE.get(NamedKey.cosmicReach(key));
    }
}

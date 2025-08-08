package sh.miles.voidcr.world.particle;

import sh.miles.voidcr.entity.PlayerEntity;
import sh.miles.voidcr.world.World;
import sh.miles.voidcr.world.position.Position;

import java.awt.Color;
import java.util.function.Consumer;

/**
 * Defines a system for creating and spawning particle effects with configurable appearance, lifetime, and emission
 * settings.
 * <p>
 * A {@link ParticleSpawner} maintains a mutable collection of particle definitions. Particles can be added and cleared
 * at any time. Spawning does not remove particles; calling a spawn method multiple times will emit the same set unless
 * the list is modified.
 *
 * @since 0.4.15
 */
public interface ParticleSpawner {

    /**
     * Adds a particle at the given position relative to the configured origin ({@link Builder#origin(Position)}).
     * <p>
     * Added particles remain until explicitly cleared and will be included in every subsequent spawn.
     *
     * @param position position offset from the origin where the particle will appear
     * @since 0.4.15
     */
    void addParticle(Position position);

    /**
     * Removes all particles currently held by this spawner.
     * <p>
     * Once cleared, no particles will spawn until new ones are added.
     *
     * @since 0.4.15
     */
    void clearParticles();

    /**
     * Spawns all stored particles in the given world, applying the provided configuration step before emission.
     * <p>
     * The configuration callback can be used to add particles or adjust settings before spawning. Particles remain
     * after spawning.
     *
     * @param world   world where particles will appear
     * @param spawner customization step executed before spawning
     * @since 0.4.15
     */
    void spawn(World world, Consumer<ParticleSpawner> spawner);

    /**
     * Spawns all stored particles in the given world without any additional configuration.
     * <p>
     * Particles remain after spawning and can be spawned again later.
     *
     * @param world world where particles will appear
     * @since 0.4.15
     */
    void spawn(World world);

    /**
     * Spawns all stored particles so they are only visible to a specific player.
     * <p>
     * Particles remain after spawning and can be reused.
     *
     * @param player the player to show the particles to
     * @since 0.4.15
     */
    void spawn(PlayerEntity player);

    /**
     * Spawns all stored particles for a specific player, applying the provided configuration step before emission.
     * <p>
     * Particles remain after spawning and can be reused.
     *
     * @param player  the player to show the particles to
     * @param spawner customization step executed before spawning
     * @since 0.4.15
     */
    void spawn(PlayerEntity player, Consumer<ParticleSpawner> spawner);

    /**
     * Builder for creating and configuring a {@link ParticleSpawner}.
     * <p>
     * Allows customization of particle attributes such as appearance, lifetime, emission duration, maximum count, and
     * spawn origin. The configuration applies to all particles added by the resulting spawner.
     *
     * @since 0.4.15
     */
    interface Builder {

        /**
         * Sets the maximum number of particles that can exist at once.
         *
         * @since 0.4.15
         */
        Builder maxParticles(int maxParticles);

        /**
         * Sets the starting color of particles.
         *
         * @since 0.4.15
         */
        Builder startColor(Color startColor);

        /**
         * Sets how long (in seconds) particles will be emitted.
         *
         * @since 0.4.15
         */
        Builder duration(float duration);

        /**
         * Sets the maximum lifespan (in seconds) of a single particle.
         *
         * @since 0.4.15
         */
        Builder maxAge(float maxAge);

        /**
         * Sets the minimum lifespan (in seconds) of a single particle.
         *
         * @since 0.4.15
         */
        Builder minAge(float minAge);

        /**
         * Sets the origin point where particle positions are relative to.
         *
         * @since 0.4.15
         */
        Builder origin(Position position);

        /**
         * Builds the configured {@link ParticleSpawner} instance.
         *
         * @since 0.4.15
         */
        ParticleSpawner build();
    }
}

package sh.miles.voidcr.world.particle;

import sh.miles.voidcr.entity.PlayerEntity;
import sh.miles.voidcr.util.Keyed;
import sh.miles.voidcr.world.World;
import sh.miles.voidcr.world.position.Position;

/**
 * Represents a particle effect type that can be spawned for a specific player or broadcast to all players in a world.
 * <p>
 * Particle types can be used directly or configured through a {@link ParticleSpawner}, which holds a mutable list of
 * particles. Reusing the same spawner without changes will produce the same particles each time.
 *
 * @since 0.4.15
 */
public interface ParticleType extends Keyed {

    /**
     * Spawns this particle effect at the given position so it is visible to the specified player.
     *
     * @param player   the player who will see the particles
     * @param position the location where the particles will appear
     * @since 0.4.15
     */
    void spawn(PlayerEntity player, Position position);

    /**
     * Spawns this particle effect at the given position for all players in the specified world.
     *
     * @param world    the world in which to spawn the particles
     * @param position the location where the particles will appear
     * @since 0.4.15
     */
    void spawn(World world, Position position);

    /**
     * Creates a {@link ParticleSpawner} with default parameters for this particle type, ready for immediate use.
     *
     * @return a ready-to-use {@link ParticleSpawner} instance
     * @since 0.4.15
     */
    ParticleSpawner defaultSpawner();

    /**
     * Creates a new {@link ParticleSpawner.Builder} for customizing parameters before creating a spawner.
     *
     * @return a new builder for creating a particle spawner for this type
     * @since 0.4.15
     */
    ParticleSpawner.Builder spawnerBuilder();
}

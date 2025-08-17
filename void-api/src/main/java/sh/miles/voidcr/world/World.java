package sh.miles.voidcr.world;

import org.jspecify.annotations.Nullable;
import sh.miles.voidcr.entity.Entity;
import sh.miles.voidcr.entity.EntityIdentifier;
import sh.miles.voidcr.entity.EntityType;
import sh.miles.voidcr.util.NamedKey;
import sh.miles.voidcr.world.block.BlockState;
import sh.miles.voidcr.world.position.BlockPos;
import sh.miles.voidcr.world.position.Position;

import java.util.Collection;
import java.util.function.Consumer;

/**
 * Represents a singular world within CosmicReach, which contains entities, chunks, blocks.
 *
 * @since 0.3.14
 */
public interface World {

    /**
     * Gets the world spawn point
     *
     * @return the world spawn point
     * @since 0.3.14
     */
    Position getWorldSpawn();

    /**
     * Sets the block state at the provided position
     *
     * @param pos   the position to set the state at
     * @param state the block state to set
     * @since 0.4.1
     */
    void setBlockState(BlockPos pos, BlockState state);

    /**
     * Gets the block state at the given position
     *
     * @param pos the position to get the block state at
     * @return the state, or null if no state
     * @since 0.4.1
     */
    @Nullable
    BlockState getBlockState(BlockPos pos);

    /**
     * Attempts to get the chunk at the given chunk position
     *
     * @param chunkX the chunk x
     * @param chunkY the chunk y
     * @param chunkZ the chunk z
     * @return the chunk, or null if the chunk has not yet been loaded
     * @since 0.3.27
     */
    Chunk getChunk(int chunkX, int chunkY, int chunkZ);

    /**
     * Attempts to get the chunk at the given block position
     *
     * @param pos the block position to get the chunk at
     * @return the chunk, or null if the chunk has not yet been loaded
     * @since 0.3.27
     */
    @Nullable
    Chunk getChunkAt(BlockPos pos);

    /**
     * Sets hte spawn point in this world
     *
     * @param spawnPoint the spawn point
     * @since 0.3.27
     */
    void setWorldSpawn(Position spawnPoint);

    /**
     * Gets an entity from a given entity identifier
     *
     * @param identifier the identifier
     * @return the identifier
     * @since 0.3.14
     */
    @Nullable
    Entity getEntity(final EntityIdentifier identifier);

    /**
     * Removes an entity from this world
     *
     * @param entity the entity to remove
     * @since 0.3.14
     */
    void removeEntity(final Entity entity);

    /**
     * Summons an entity into this world at the given position
     * <p>
     * Note, while this method has generics you must ensure the given {@link EntityType} corresponds to the correct
     * consumer type, otherwise this method will fail at runtime.
     *
     * @param entityType the entity type to spawn
     * @param position   the position to spawn the entity type at
     * @param prepare    spawn preparations
     * @param <E>        the entity type. Type not ensured by {@link EntityType}
     * @return the spawned entity if successfully summoned, otherwise null
     * @since 0.4.15
     */
    <E extends Entity> E summonEntity(EntityType entityType, Position position, Consumer<E> prepare);

    /**
     * Gets all entities within this world
     *
     * @return all entities within this world
     * @since 0.3.14
     */
    Collection<Entity> getEntities();

    /**
     * Gets the universe this world belongs too
     *
     * @return the universe of this world
     * @since 0.3.14
     */
    Universe getUniverse();

    /**
     * Gets the world id
     *
     * @return the world id
     * @since 0.3.14
     */
    NamedKey getWorldId();

}

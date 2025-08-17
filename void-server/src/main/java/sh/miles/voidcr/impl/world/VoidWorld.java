package sh.miles.voidcr.impl.world;

import com.badlogic.gdx.utils.Array;
import com.google.common.base.Preconditions;
import finalforeach.cosmicreach.entities.EntityCreator;
import finalforeach.cosmicreach.world.BlockSetter;
import finalforeach.cosmicreach.world.Zone;
import org.jspecify.annotations.Nullable;
import sh.miles.voidcr.entity.Entity;
import sh.miles.voidcr.entity.EntityIdentifier;
import sh.miles.voidcr.entity.EntityType;
import sh.miles.voidcr.impl.entity.VoidEntity;
import sh.miles.voidcr.impl.entity.VoidEntityIdentifier;
import sh.miles.voidcr.impl.util.VoidNamedKey;
import sh.miles.voidcr.impl.world.block.VoidBlockState;
import sh.miles.voidcr.impl.world.position.VoidBlockPos;
import sh.miles.voidcr.impl.world.position.VoidPosition;
import sh.miles.voidcr.util.Mirrored;
import sh.miles.voidcr.util.NamedKey;
import sh.miles.voidcr.world.Chunk;
import sh.miles.voidcr.world.Universe;
import sh.miles.voidcr.world.World;
import sh.miles.voidcr.world.block.BlockState;
import sh.miles.voidcr.world.position.BlockPos;
import sh.miles.voidcr.world.position.Position;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

public final class VoidWorld implements World, Mirrored<Zone> {

    private final Zone mirror;
    private final NamedKey key;

    public VoidWorld(Zone mirror) {
        this.mirror = mirror;
        this.key = NamedKey.key(mirror.zoneId);
    }

    @Override
    public Zone getMirror() {
        return this.mirror;
    }

    @Override
    public Position getWorldSpawn() {
        return VoidPosition.fromVector3(mirror.spawnPoint);
    }

    @Override
    public void setBlockState(final BlockPos pos, final BlockState state) {
        final var crstate = ((VoidBlockState) state).getMirror();
        mirror.setBlockState(crstate, pos.x(), pos.y(), pos.z());
        BlockSetter.get().replaceBlock(this.mirror, crstate, VoidBlockPos.toGlobalCRPos(this.mirror, pos));
    }

    @Override
    public @Nullable BlockState getBlockState(final BlockPos pos) {
        final var state = mirror.getBlockState(pos.x(), pos.y(), pos.z());
        return state != null ? state.getVoidMirror() : null;
    }

    @Override
    public Chunk getChunk(final int chunkX, final int chunkY, final int chunkZ) {
        final var chunk = mirror.getChunkAtChunkCoords(chunkX, chunkY, chunkZ);
        return chunk == null ? null : chunk.getVoidMirror();
    }

    @Override
    public Chunk getChunkAt(final BlockPos pos) {
        final var chunk = mirror.getChunkAtBlock(pos.x(), pos.y(), pos.z());
        return chunk == null ? null : chunk.getVoidMirror();
    }

    @Override
    public void setWorldSpawn(final Position spawnPoint) {
        Preconditions.checkArgument(spawnPoint != null, "The given spawn point must not be null");
        this.mirror.spawnPoint = VoidPosition.toVector3(spawnPoint);
    }

    @Override
    public Entity getEntity(final EntityIdentifier identifier) {
        Preconditions.checkArgument(identifier != null, "The given identifier must not be null");
        return this.mirror.getEntity(((VoidEntityIdentifier) identifier).getMirror()).getVoidMirror();
    }

    @Override
    public void removeEntity(final Entity entity) {
        Preconditions.checkArgument(entity != null, "The provided entity must not be null");
        this.mirror.removeEntity(((VoidEntity) entity).getMirror());
    }

    @Override
    public <E extends Entity> E summonEntity(final EntityType entityType, final Position position, final Consumer<E> prepare) {
        final finalforeach.cosmicreach.entities.Entity entity = EntityCreator.get(((VoidNamedKey) entityType.key()).getCosmicReachId());
        if (entity == null) {
            return null;
        }

        final E mirror = (E) entity.getVoidMirror();
        prepare.accept(mirror); // could cause class cast exception, because EntityType doesn't ensure prepare aligns with actual entity type

        entity.setPosition(VoidPosition.toVector3(position));
        getMirror().addEntity(entity);
        // not recounting mobs here could overflow mob cap, but that's okay we just assume plugins are deliberate
        return mirror;
    }

    @Override
    public Collection<Entity> getEntities() {
        final Array<finalforeach.cosmicreach.entities.Entity> entities = this.mirror.getAllEntities();
        final List<Entity> collector = new ArrayList<>(entities.size);
        for (final finalforeach.cosmicreach.entities.Entity entity : entities) {
            collector.add(entity.getVoidMirror());
        }
        return collector;
    }

    @Override
    public Universe getUniverse() {
        return mirror.getWorld().getVoidMirror();
    }

    @Override
    public NamedKey getWorldId() {
        return this.key;
    }
}

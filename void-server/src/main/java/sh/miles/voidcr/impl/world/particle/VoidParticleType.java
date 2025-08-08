package sh.miles.voidcr.impl.world.particle;

import finalforeach.cosmicreach.networking.packets.ParticleSystemPacket;
import finalforeach.cosmicreach.networking.server.ServerSingletons;
import finalforeach.cosmicreach.particles.GameParticleSystem;
import org.jspecify.annotations.NullMarked;
import sh.miles.voidcr.entity.PlayerEntity;
import sh.miles.voidcr.impl.entity.VoidPlayerEntity;
import sh.miles.voidcr.impl.world.VoidWorld;
import sh.miles.voidcr.impl.world.position.VoidPosition;
import sh.miles.voidcr.util.Mirrored;
import sh.miles.voidcr.util.NamedKey;
import sh.miles.voidcr.world.World;
import sh.miles.voidcr.world.particle.ParticleSpawner;
import sh.miles.voidcr.world.particle.ParticleType;
import sh.miles.voidcr.world.position.Position;

@NullMarked
public class VoidParticleType implements ParticleType, Mirrored<GameParticleSystem> {

    private final GameParticleSystem mirror;

    public VoidParticleType(GameParticleSystem mirror) {
        this.mirror = mirror;
        mirror.setOrigin(0, 0, 0);
    }

    @Override
    public void spawn(final PlayerEntity player, final Position position) {
        final var copy = mirror.copy();
        copy.setOrigin(VoidPosition.toVector3(position));
        ServerSingletons.getConnection(((VoidPlayerEntity) player).getMirror().getPlayer()).send(new ParticleSystemPacket(copy));
    }

    @Override
    public void spawn(final World world, final Position position) {
        final var copy = mirror.copy();
        copy.setOrigin(VoidPosition.toVector3(position));
        ServerSingletons.SERVER.broadcast(((VoidWorld) world).getMirror(), new ParticleSystemPacket(copy));
    }

    @Override
    public ParticleSpawner defaultSpawner() {
        return new VoidParticleSpawner(mirror);
    }

    @Override
    public ParticleSpawner.Builder spawnerBuilder() {
        return new VoidParticleSpawner.VoidBuilder(mirror);
    }

    @Override
    public NamedKey key() {
        return NamedKey.key(mirror.id);
    }

    @Override
    public GameParticleSystem getMirror() {
        return this.mirror.copy();
    }
}

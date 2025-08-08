package sh.miles.voidcr.impl.world.particle;

import com.google.common.base.Preconditions;
import finalforeach.cosmicreach.networking.NetworkIdentity;
import finalforeach.cosmicreach.networking.packets.ParticleSystemPacket;
import finalforeach.cosmicreach.networking.server.ServerSingletons;
import finalforeach.cosmicreach.particles.GameParticleSystem;
import sh.miles.voidcr.entity.PlayerEntity;
import sh.miles.voidcr.impl.entity.VoidPlayerEntity;
import sh.miles.voidcr.impl.world.VoidWorld;
import sh.miles.voidcr.impl.world.position.VoidPosition;
import sh.miles.voidcr.world.World;
import sh.miles.voidcr.world.particle.ParticleSpawner;
import sh.miles.voidcr.world.position.Position;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Default implementation of {@link ParticleSpawner} backed by a {@link GameParticleSystem}.
 */
class VoidParticleSpawner implements ParticleSpawner {

    private final GameParticleSystem system;
    private final List<GameParticleSystem> particles = new ArrayList<>();

    public VoidParticleSpawner(GameParticleSystem system) {
        this.system = system.copy();
    }

    @Override
    public void addParticle(final Position position) {
        Preconditions.checkArgument(position != null, "The provided position must not be null");
        final GameParticleSystem naiveParticleCopy = system.copy();
        naiveParticleCopy.setOrigin(VoidPosition.toVector3(position).add(system.getOriginX(), system.getOriginY(), system.getOriginZ()));
        particles.add(naiveParticleCopy);
    }

    @Override
    public void clearParticles() {
        this.particles.clear();
    }

    @Override
    public void spawn(World world, Consumer<ParticleSpawner> spawner) {
        Preconditions.checkArgument(spawner != null, "The provided spawner function must not be null");
        spawner.accept(this);
        spawn(world);
    }

    @Override
    public void spawn(World world) {
        Preconditions.checkArgument(world != null, "The provided world must not be null");
        for (final GameParticleSystem particle : particles) {
            ServerSingletons.SERVER.broadcast(((VoidWorld) world).getMirror(), new ParticleSystemPacket(particle));
        }
    }

    @Override
    public void spawn(final PlayerEntity player) {
        Preconditions.checkArgument(player != null, "The provided world must not be null");
        NetworkIdentity identity = ServerSingletons.getConnection(((VoidPlayerEntity) player).getMirror().getPlayer());
        for (final GameParticleSystem particle : particles) {
            identity.send(new ParticleSystemPacket(particle));
        }
    }

    @Override
    public void spawn(final PlayerEntity player, final Consumer<ParticleSpawner> spawner) {
        Preconditions.checkArgument(spawner != null, "The provided spawner function must not be null");
        spawner.accept(this);
        spawn(player);
    }

    /**
     * Builder for {@link VoidParticleSpawner}.
     */
    public static class VoidBuilder implements Builder {

        private final GameParticleSystem system;

        public VoidBuilder(GameParticleSystem system) {
            this.system = system.copy();
        }

        @Override
        public Builder maxParticles(int maxParticles) {
            system.maxParticles = maxParticles;
            return this;
        }

        @Override
        public Builder startColor(Color startColor) {
            if (startColor.getRed() == 255 && startColor.getBlue() == 255 && startColor.getGreen() == 255) {
                startColor = new Color(255, 254, 255); // actual white crashes the client, effectively white does not
            }
            system.startColor.set(com.badlogic.gdx.graphics.Color.argb8888(startColor.getRed() / 255f, startColor.getGreen() / 255f, startColor.getBlue() / 255f, startColor.getAlpha() / 255f));
            return this;
        }

        @Override
        public Builder duration(float duration) {
            system.duration = duration;
            return this;
        }

        @Override
        public Builder maxAge(float maxAge) {
            system.maxAge = maxAge;
            return this;
        }

        @Override
        public Builder minAge(float minAge) {
            system.minAge = minAge;
            return this;
        }

        @Override
        public Builder origin(Position position) {
            system.setOrigin(VoidPosition.toVector3(position));
            return this;
        }

        @Override
        public ParticleSpawner build() {
            return new VoidParticleSpawner(system);
        }
    }
}

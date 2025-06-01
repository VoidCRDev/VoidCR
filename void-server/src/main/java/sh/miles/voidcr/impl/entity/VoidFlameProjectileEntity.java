package sh.miles.voidcr.impl.entity;

import finalforeach.cosmicreach.entities.Entity;
import finalforeach.cosmicreach.entities.EntityFlameProjectile;
import org.jspecify.annotations.Nullable;
import sh.miles.voidcr.entity.EntityIdentifier;
import sh.miles.voidcr.entity.ProjectileEntity;

public class VoidFlameProjectileEntity extends VoidEntity implements ProjectileEntity {
    public VoidFlameProjectileEntity(final EntityFlameProjectile mirror) {
        super(mirror);
    }

    @Override
    public void setStrength(final float strength) {
        getMirror().strength = strength;
    }

    @Override
    public float getStrength() {
        return getMirror().strength;
    }

    @Override
    public float getRadius() {
        return getMirror().radius;
    }

    @Override
    public @Nullable EntityIdentifier getProjectileLauncher() {
        final var launcher = getMirror().sourceEntityId;
        return launcher == null ? null :  new VoidEntityIdentifier(launcher);
    }

    @Override
    public EntityFlameProjectile getMirror() {
        return (EntityFlameProjectile) super.getMirror();
    }
}

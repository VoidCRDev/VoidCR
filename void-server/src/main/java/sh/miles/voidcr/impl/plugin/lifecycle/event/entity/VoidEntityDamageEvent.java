package sh.miles.voidcr.impl.plugin.lifecycle.event.entity;

import finalforeach.cosmicreach.entities.IDamageSource;
import finalforeach.cosmicreach.world.Zone;
import sh.miles.voidcr.entity.Entity;
import sh.miles.voidcr.impl.plugin.lifecycle.event.VoidLifecycleEvent;
import sh.miles.voidcr.impl.world.damage.VoidDamageSource;
import sh.miles.voidcr.plugin.lifecycle.event.entity.EntityDamageEvent;
import sh.miles.voidcr.server.Server;
import sh.miles.voidcr.world.World;
import sh.miles.voidcr.world.damage.DamageSource;

public abstract class VoidEntityDamageEvent extends VoidEntityEvent implements EntityDamageEvent {

    protected int invulnerabilityFrames;
    protected float damage;
    private final Entity damager;
    private final DamageSource source;

    public VoidEntityDamageEvent(final Server ctx, final finalforeach.cosmicreach.entities.Entity effected, final int invulnerabilityFrames, final float damage, final IDamageSource source) {
        super(ctx, effected, effected.zone);
        this.invulnerabilityFrames = invulnerabilityFrames;
        this.damage = damage;
        this.source = VoidDamageSource.toVoidSource(source);
        this.damager = source instanceof Entity entity ? entity : null;
    }

    @Override
    public int getInvulnerabilityFrames() {
        return this.invulnerabilityFrames;
    }

    @Override
    public float getDamage() {
        return this.damage;
    }

    @Override
    public DamageSource getDamageSource() {
        return this.source;
    }
}

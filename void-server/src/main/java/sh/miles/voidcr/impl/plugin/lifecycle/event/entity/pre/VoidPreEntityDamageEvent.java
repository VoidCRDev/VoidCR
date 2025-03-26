package sh.miles.voidcr.impl.plugin.lifecycle.event.entity.pre;

import finalforeach.cosmicreach.entities.Entity;
import finalforeach.cosmicreach.entities.IDamageSource;
import finalforeach.cosmicreach.world.Zone;
import sh.miles.voidcr.impl.plugin.lifecycle.event.entity.VoidEntityDamageEvent;
import sh.miles.voidcr.plugin.lifecycle.event.LifecycleEvent;
import sh.miles.voidcr.plugin.lifecycle.event.entity.pre.PreEntityDamageEvent;
import sh.miles.voidcr.server.Server;

public final class VoidPreEntityDamageEvent extends VoidEntityDamageEvent implements PreEntityDamageEvent {

    private boolean canceled = false;

    public VoidPreEntityDamageEvent(final Server ctx, final Entity entity, final int invulnerabilityFrames, final float damage, final IDamageSource source) {
        super(ctx, entity, invulnerabilityFrames, damage, source);
    }

    @Override
    public void setInvulnerabilityFrames(final int invulnerabilityFrames) {
        super.invulnerabilityFrames = invulnerabilityFrames;
    }

    @Override
    public void setDamage(final float pendingDamage) {
        super.damage = pendingDamage;
    }

    @Override
    public void setCanceled(final boolean canceled) {
        this.canceled = canceled;
    }

    @Override
    public boolean isCanceled() {
        return this.canceled;
    }

    @Override
    public Class<? extends LifecycleEvent<Server>> getEventClass() {
        return PreEntityDamageEvent.class;
    }
}

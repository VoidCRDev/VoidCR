package sh.miles.voidcr.impl.plugin.lifecycle.event.entity.post;

import finalforeach.cosmicreach.entities.Entity;
import finalforeach.cosmicreach.entities.IDamageSource;
import finalforeach.cosmicreach.world.Zone;
import sh.miles.voidcr.impl.plugin.lifecycle.event.entity.VoidEntityDamageEvent;
import sh.miles.voidcr.plugin.lifecycle.event.LifecycleEvent;
import sh.miles.voidcr.plugin.lifecycle.event.entity.post.PostEntityDamageEvent;
import sh.miles.voidcr.server.Server;

public final class VoidPostEntityDamageEvent extends VoidEntityDamageEvent implements PostEntityDamageEvent {

    public VoidPostEntityDamageEvent(final Server ctx, final Entity entity, final int invulnerabilityFrames, final float damage, final IDamageSource source) {
        super(ctx, entity, invulnerabilityFrames, damage, source);
    }

    @Override
    public Class<? extends LifecycleEvent<Server>> getEventClass() {
        return PostEntityDamageEvent.class;
    }
}

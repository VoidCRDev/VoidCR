package sh.miles.voidcr.impl.plugin.lifecycle.event.entity.post;

import finalforeach.cosmicreach.entities.Entity;
import sh.miles.voidcr.impl.plugin.lifecycle.event.entity.VoidEntityUseJetpackEvent;
import sh.miles.voidcr.plugin.lifecycle.event.LifecycleEvent;
import sh.miles.voidcr.plugin.lifecycle.event.entity.post.PostEntityUseJetpackEvent;
import sh.miles.voidcr.server.Server;

public class VoidPostEntityUseJetpackEvent extends VoidEntityUseJetpackEvent implements PostEntityUseJetpackEvent {
    public VoidPostEntityUseJetpackEvent(final Server ctx, final Entity entity, final boolean isUsingJetpack) {
        super(ctx, entity, isUsingJetpack);
    }

    @Override
    public Class<? extends LifecycleEvent<Server>> getEventClass() {
        return PostEntityUseJetpackEvent.class;
    }
}

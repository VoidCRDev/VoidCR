package sh.miles.voidcr.impl.plugin.lifecycle.event.entity.pre;

import finalforeach.cosmicreach.entities.Entity;
import sh.miles.voidcr.impl.plugin.lifecycle.event.entity.VoidEntityUseJetpackEvent;
import sh.miles.voidcr.plugin.lifecycle.event.LifecycleEvent;
import sh.miles.voidcr.plugin.lifecycle.event.entity.pre.PreEntityUseJetpackEvent;
import sh.miles.voidcr.server.Server;

public class VoidPreEntityUseJetpackEvent extends VoidEntityUseJetpackEvent implements PreEntityUseJetpackEvent {

    public VoidPreEntityUseJetpackEvent(final Server ctx, final Entity entity, final boolean isUsingJetpack) {
        super(ctx, entity, isUsingJetpack);
    }

    @Override
    public void setUsingJetpack(final boolean status) {
        super.isUsingJetpack = status;
    }

    @Override
    public Class<? extends LifecycleEvent<Server>> getEventClass() {
        return PreEntityUseJetpackEvent.class;
    }
}

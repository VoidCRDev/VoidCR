package sh.miles.voidcr.impl.plugin.lifecycle.event.entity;

import finalforeach.cosmicreach.entities.Entity;
import sh.miles.voidcr.plugin.lifecycle.event.entity.EntityUseJetpackEvent;
import sh.miles.voidcr.server.Server;

public abstract class VoidEntityUseJetpackEvent extends VoidEntityEvent implements EntityUseJetpackEvent {

    protected boolean isUsingJetpack;

    public VoidEntityUseJetpackEvent(final Server ctx, final Entity entity, boolean isUsingJetpack) {
        super(ctx, entity, entity.zone);
        this.isUsingJetpack = isUsingJetpack;
    }

    @Override
    public boolean isUsingJetpack() {
        return this.isUsingJetpack;
    }
}

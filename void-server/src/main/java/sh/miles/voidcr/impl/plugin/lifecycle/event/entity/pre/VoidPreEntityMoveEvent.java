package sh.miles.voidcr.impl.plugin.lifecycle.event.entity.pre;

import com.badlogic.gdx.math.Vector3;
import finalforeach.cosmicreach.entities.Entity;
import sh.miles.voidcr.impl.plugin.lifecycle.event.entity.VoidEntityMoveEvent;
import sh.miles.voidcr.plugin.lifecycle.event.LifecycleEvent;
import sh.miles.voidcr.plugin.lifecycle.event.entity.pre.PreEntityMoveEvent;
import sh.miles.voidcr.server.Server;
import sh.miles.voidcr.world.position.Position;

public final class VoidPreEntityMoveEvent extends VoidEntityMoveEvent implements PreEntityMoveEvent {

    public VoidPreEntityMoveEvent(final Server ctx, final Entity entity, final Vector3 from, final Vector3 to, final boolean isOnGround) {
        super(ctx, entity, from, to, isOnGround);
    }

    @Override
    public void setTo(final Position position) {
        super.to = position;
    }

    @Override
    public void setFrom(final Position position) {
        super.from = position;
    }

    @Override
    public Class<? extends LifecycleEvent<Server>> getEventClass() {
        return PreEntityMoveEvent.class;
    }
}

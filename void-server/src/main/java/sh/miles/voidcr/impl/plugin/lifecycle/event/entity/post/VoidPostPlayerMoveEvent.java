package sh.miles.voidcr.impl.plugin.lifecycle.event.entity.post;

import com.badlogic.gdx.math.Vector3;
import finalforeach.cosmicreach.entities.Entity;
import sh.miles.voidcr.impl.plugin.lifecycle.event.entity.VoidPlayerMoveEvent;
import sh.miles.voidcr.plugin.lifecycle.event.LifecycleEvent;
import sh.miles.voidcr.plugin.lifecycle.event.entity.post.PostPlayerMoveEvent;
import sh.miles.voidcr.server.Server;

public class VoidPostPlayerMoveEvent extends VoidPlayerMoveEvent implements PostPlayerMoveEvent {
    public VoidPostPlayerMoveEvent(final Server ctx, final Entity entity, final Vector3 from, final Vector3 to, final Vector3 viewDirection, final Vector3 viewPositionOffset, final boolean isOnGround, final boolean isSneaking, final boolean isSprinting, final boolean isProne) {
        super(ctx, entity, from, to, viewDirection, viewPositionOffset, isOnGround, isSneaking, isSprinting, isProne);
    }

    @Override
    public Class<? extends LifecycleEvent<Server>> getEventClass() {
        return PostPlayerMoveEvent.class;
    }
}

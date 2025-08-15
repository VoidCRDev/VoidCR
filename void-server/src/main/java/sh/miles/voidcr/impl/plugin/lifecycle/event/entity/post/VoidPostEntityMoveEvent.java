package sh.miles.voidcr.impl.plugin.lifecycle.event.entity.post;

import com.badlogic.gdx.math.Vector3;
import finalforeach.cosmicreach.entities.Entity;
import sh.miles.voidcr.impl.plugin.lifecycle.event.entity.VoidEntityMoveEvent;
import sh.miles.voidcr.plugin.lifecycle.event.LifecycleEvent;
import sh.miles.voidcr.plugin.lifecycle.event.entity.post.PostEntityMoveEvent;
import sh.miles.voidcr.server.Server;

public class VoidPostEntityMoveEvent extends VoidEntityMoveEvent implements PostEntityMoveEvent {
    public VoidPostEntityMoveEvent(final Server ctx, final Entity entity, final Vector3 from, final Vector3 to, final boolean isOnGround) {
        super(ctx, entity, from, to, isOnGround);
    }

    @Override
    public Class<? extends LifecycleEvent<Server>> getEventClass() {
        return PostEntityMoveEvent.class;
    }
}

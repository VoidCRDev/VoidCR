package sh.miles.voidcr.impl.plugin.lifecycle.event.entity;

import com.badlogic.gdx.math.Vector3;
import finalforeach.cosmicreach.entities.Entity;
import sh.miles.voidcr.impl.world.position.VoidPosition;
import sh.miles.voidcr.plugin.lifecycle.event.entity.EntityMoveEvent;
import sh.miles.voidcr.server.Server;
import sh.miles.voidcr.world.position.Position;

public abstract class VoidEntityMoveEvent extends VoidEntityEvent implements EntityMoveEvent {

    protected Position from;
    protected Position to;
    protected boolean isOnGround;

    public VoidEntityMoveEvent(final Server ctx, final Entity entity, Vector3 from, Vector3 to, boolean isOnGround) {
        super(ctx, entity, entity.zone);
        this.from = VoidPosition.fromVector3(from);
        this.to = VoidPosition.fromVector3(to);
        this.isOnGround = isOnGround;
    }


    @Override
    public Position getFrom() {
        return this.from;
    }

    @Override
    public Position getTo() {
        return this.to;
    }

    @Override
    public boolean isOnGround() {
        return this.isOnGround;
    }
}

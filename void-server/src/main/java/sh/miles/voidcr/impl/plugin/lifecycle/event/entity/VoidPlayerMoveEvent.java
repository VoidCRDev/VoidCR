package sh.miles.voidcr.impl.plugin.lifecycle.event.entity;

import com.badlogic.gdx.math.Vector3;
import finalforeach.cosmicreach.entities.Entity;
import sh.miles.voidcr.entity.PlayerEntity;
import sh.miles.voidcr.impl.world.position.VoidVector;
import sh.miles.voidcr.plugin.lifecycle.event.entity.PlayerMoveEvent;
import sh.miles.voidcr.server.Server;
import sh.miles.voidcr.world.position.Vector;

public abstract class VoidPlayerMoveEvent extends VoidEntityMoveEvent implements PlayerMoveEvent {

    protected Vector viewDirection;
    protected Vector viewPositionOffset;
    protected boolean isSneaking;
    protected boolean isSprinting;
    protected boolean isProne;

    public VoidPlayerMoveEvent(final Server ctx, final Entity entity, final Vector3 from, final Vector3 to, Vector3 viewDirection, Vector3 viewPositionOffset, final boolean isOnGround, boolean isSneaking, boolean isSprinting, boolean isProne) {
        super(ctx, entity, from, to, isOnGround);
        this.viewDirection = VoidVector.fromVector3(viewDirection);
        this.viewPositionOffset = VoidVector.fromVector3(viewPositionOffset);
        this.isSneaking = isSneaking;
        this.isSprinting = isSprinting;
        this.isProne = isProne;
    }

    @Override
    public Vector getViewDirection() {
        return this.viewDirection;
    }

    @Override
    public Vector getViewPositionOffset() {
        return this.viewPositionOffset;
    }

    @Override
    public boolean isSneaking() {
        return this.isSneaking;
    }

    @Override
    public boolean isSprinting() {
        return this.isSprinting;
    }

    @Override
    public boolean isProne() {
        return this.isProne;
    }

    @Override
    public PlayerEntity getPlayer() {
        return (PlayerEntity) getEntity();
    }
}

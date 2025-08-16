package sh.miles.voidcr.impl.plugin.lifecycle.event.entity.pre;

import com.badlogic.gdx.math.Vector3;
import finalforeach.cosmicreach.entities.Entity;
import finalforeach.cosmicreach.networking.packets.entities.PlayerPositionPacket;
import sh.miles.voidcr.impl.plugin.lifecycle.event.entity.VoidPlayerMoveEvent;
import sh.miles.voidcr.plugin.lifecycle.event.LifecycleEvent;
import sh.miles.voidcr.plugin.lifecycle.event.entity.pre.PrePlayerMoveEvent;
import sh.miles.voidcr.server.Server;
import sh.miles.voidcr.world.position.Vector;

public class VoidPrePlayerMoveEvent extends VoidPlayerMoveEvent implements PrePlayerMoveEvent {

    public boolean isModified;

    public VoidPrePlayerMoveEvent(final Server ctx, final Entity entity, final Vector3 from, final Vector3 to, final Vector3 viewDirection, final Vector3 viewPositionOffset, final boolean isOnGround, final boolean isSneaking, final boolean isSprinting, final boolean isProne) {
        super(ctx, entity, from, to, viewDirection, viewPositionOffset, isOnGround, isSneaking, isSprinting, isProne);
    }

    @Override
    public void setViewDirection(final Vector viewDirection) {
        super.viewDirection = viewDirection;
        this.isModified = true;
    }

    @Override
    public void setViewPositionOffset(final Vector viewDirectionOffset) {
        super.viewPositionOffset = viewDirectionOffset;
        this.isModified = true;
    }

    @Override
    public void setSneaking(final boolean sneaking) {
        super.isSneaking = sneaking;
        this.isModified = true;
    }

    @Override
    public void setSprinting(final boolean sprinting) {
        super.isSprinting = sprinting;
        this.isModified = true;
    }

    @Override
    public void setProne(final boolean prone) {
        super.isProne = prone;
        this.isModified = true;
    }

    @Override
    public Class<? extends LifecycleEvent<Server>> getEventClass() {
        return PrePlayerMoveEvent.class;
    }

    public int getFlags() {
        int flags = 0;
        flags = addFlag(flags, PlayerPositionPacket.PLAYER_FLAG_SNEAKING, super.isSneaking);
        flags = addFlag(flags, PlayerPositionPacket.PLAYER_FLAG_SPRINTING, super.isSprinting);
        flags = addFlag(flags, PlayerPositionPacket.PLAYER_FLAG_PRONE, super.isProne);
        flags = addFlag(flags, PlayerPositionPacket.PLAYER_FLAG_ON_GROUND, super.isOnGround);

        return flags;
    }

    public static final int addFlag(int current, int flagMask, boolean flagValue) {
        if (flagValue) {
            current |= flagMask;
        } else {
            current &= ~flagMask;
        }

        return current;
    }
}

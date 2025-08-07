package sh.miles.voidcr.impl.entity;

import finalforeach.cosmicreach.entities.mobs.MobDroneTrap;
import sh.miles.voidcr.entity.DroneTrapEntity;

public class VoidDroneTrapEntity extends VoidEntity implements DroneTrapEntity {

    public VoidDroneTrapEntity(final MobDroneTrap mirror) {
        super(mirror);
    }

    @Override
    public void release() {
        getMirror().releaseTrap();
    }

    @Override
    public MobDroneTrap getMirror() {
        return (MobDroneTrap) super.mirror;
    }
}

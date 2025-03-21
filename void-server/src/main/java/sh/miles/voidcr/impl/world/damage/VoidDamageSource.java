package sh.miles.voidcr.impl.world.damage;

import finalforeach.cosmicreach.entities.Entity;
import finalforeach.cosmicreach.entities.IDamageSource;
import sh.miles.voidcr.world.damage.DamageSource;

public class VoidDamageSource implements DamageSource {
    public static VoidDamageSource ENVIRONMENT = new VoidDamageSource();

    public static DamageSource toVoidSource(IDamageSource source) {
        return switch (source) {
            case Entity entity -> entity.getVoidMirror();
            case null -> throw new IllegalArgumentException("Can not find null source in VoidDamageSource#toDamageSource");
            default -> ENVIRONMENT;
        };
    }
}

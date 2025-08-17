package sh.miles.voidcr.impl.entity;

import sh.miles.voidcr.entity.EntityType;
import sh.miles.voidcr.util.NamedKey;

public class VoidEntityType implements EntityType {

    private final NamedKey key;

    public VoidEntityType(String raw) {
        this.key = NamedKey.key(raw);
    }

    @Override
    public NamedKey key() {
        return this.key;
    }
}

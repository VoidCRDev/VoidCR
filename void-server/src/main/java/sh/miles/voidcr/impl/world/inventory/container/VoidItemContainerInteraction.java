package sh.miles.voidcr.impl.world.inventory.container;

import finalforeach.cosmicreach.networking.packets.items.SlotInteractionType;
import sh.miles.voidcr.util.NamedKey;
import sh.miles.voidcr.world.inventory.container.ItemContainerInteraction;

import java.util.Objects;

public class VoidItemContainerInteraction implements ItemContainerInteraction {
    private final NamedKey key;

    public VoidItemContainerInteraction(SlotInteractionType type) {
        this.key = NamedKey.cosmicReach(type.name().toLowerCase());
    }

    @Override
    public NamedKey key() {
        return this.key;
    }

    @Override
    public String toString() {
        return this.key.toString();
    }

    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof final VoidItemContainerInteraction that)) return false;
        return Objects.equals(key, that.key);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(key);
    }
}

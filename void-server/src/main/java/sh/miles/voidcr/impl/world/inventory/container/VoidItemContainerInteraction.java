package sh.miles.voidcr.impl.world.inventory.container;

import finalforeach.cosmicreach.networking.packets.items.SlotInteractionType;
import sh.miles.voidcr.util.NamedKey;
import sh.miles.voidcr.world.inventory.container.ItemContainerInteraction;

public class VoidItemContainerInteraction implements ItemContainerInteraction {

    private final NamedKey key;

    public VoidItemContainerInteraction(SlotInteractionType type) {
        this.key = NamedKey.cosmicReach(type.name().toLowerCase());
    }

    @Override
    public NamedKey key() {
        return this.key;
    }
}

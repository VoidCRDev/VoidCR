package sh.miles.voidcr.impl.plugin.lifecycle.event.world.inventory.container;

import finalforeach.cosmicreach.entities.player.Player;
import finalforeach.cosmicreach.items.containers.SlotContainer;
import finalforeach.cosmicreach.networking.packets.items.SlotInteractionType;
import sh.miles.voidcr.entity.PlayerEntity;
import sh.miles.voidcr.plugin.lifecycle.event.world.inventory.container.PlayerItemContainerInteractEvent;
import sh.miles.voidcr.server.Server;
import sh.miles.voidcr.server.registry.Registries;
import sh.miles.voidcr.util.NamedKey;
import sh.miles.voidcr.world.inventory.container.ItemContainerInteraction;

public abstract class VoidPlayerItemContainerInteractEvent extends VoidItemContainerEvent implements PlayerItemContainerInteractEvent {

    private final int slot;
    private final PlayerEntity player;
    private final ItemContainerInteraction interaction;

    public VoidPlayerItemContainerInteractEvent(final Server context, final SlotContainer container, final int slot, final Player player, final SlotInteractionType interaction) {
        super(context, container);
        this.slot = slot;
        this.player = (PlayerEntity) player.getEntity().getVoidMirror();
        this.interaction = Registries.ITEM_CONTAINER_INTERACT.getOrThrow(NamedKey.cosmicReach(interaction.name().toLowerCase()));
    }

    @Override
    public int getSlot() {
        return this.slot;
    }

    @Override
    public PlayerEntity getPlayer() {
        return this.player;
    }

    @Override
    public ItemContainerInteraction getInteraction() {
        return this.interaction;
    }
}

package sh.miles.voidcr.impl.plugin.lifecycle.event.world.inventory.container.post;

import finalforeach.cosmicreach.entities.player.Player;
import finalforeach.cosmicreach.items.ItemStack;
import finalforeach.cosmicreach.items.containers.SlotContainer;
import finalforeach.cosmicreach.networking.packets.items.SlotInteractionType;
import sh.miles.voidcr.impl.plugin.lifecycle.event.world.inventory.container.VoidPlayerItemContainerInteractEvent;
import sh.miles.voidcr.plugin.lifecycle.event.LifecycleEvent;
import sh.miles.voidcr.plugin.lifecycle.event.world.inventory.container.post.PostPlayerItemContainerInteractEvent;
import sh.miles.voidcr.server.Server;

public class VoidPostPlayerInteractContainerEvent extends VoidPlayerItemContainerInteractEvent implements PostPlayerItemContainerInteractEvent {

    public VoidPostPlayerInteractContainerEvent(final Server context, final SlotContainer container, final int slot, final Player player, final SlotInteractionType interaction, final ItemStack itemStack) {
        super(context, container, slot, player, interaction, itemStack);
    }

    @Override
    public Class<? extends LifecycleEvent<Server>> getEventClass() {
        return PostPlayerItemContainerInteractEvent.class;
    }
}

package sh.miles.voidcr.impl.plugin.lifecycle.event.world.inventory.container.pre;

import com.google.common.base.Preconditions;
import finalforeach.cosmicreach.entities.player.Player;
import finalforeach.cosmicreach.items.containers.SlotContainer;
import finalforeach.cosmicreach.networking.packets.items.SlotInteractionType;
import sh.miles.voidcr.impl.plugin.lifecycle.event.world.inventory.container.VoidPlayerItemContainerInteractEvent;
import sh.miles.voidcr.impl.world.inventory.item.VoidItemStack;
import sh.miles.voidcr.plugin.lifecycle.event.LifecycleEvent;
import sh.miles.voidcr.plugin.lifecycle.event.world.inventory.container.pre.PrePlayerItemContainerInteractEvent;
import sh.miles.voidcr.server.Server;
import sh.miles.voidcr.world.inventory.item.ItemStack;

public class VoidPrePlayerItemContainerInteractEvent extends VoidPlayerItemContainerInteractEvent implements PrePlayerItemContainerInteractEvent {

    private ItemStack itemStack;
    private boolean canceled;

    public VoidPrePlayerItemContainerInteractEvent(final Server context, final SlotContainer container, final int slot, final Player player, final SlotInteractionType interaction, finalforeach.cosmicreach.items.ItemStack itemStack) {
        super(context, container, slot, player, interaction);
        this.itemStack = itemStack.getVoidMirror();
        this.canceled = false;
    }

    @Override
    public void setItem(final ItemStack item) {
        Preconditions.checkArgument(item != null, "The provided item in setItem mustn't be null");
        this.itemStack = item;
    }

    @Override
    public void setCanceled(final boolean canceled) {
        this.canceled = canceled;
    }

    @Override
    public boolean isCanceled() {
        return this.canceled;
    }

    @Override
    public Class<? extends LifecycleEvent<Server>> getEventClass() {
        return PrePlayerItemContainerInteractEvent.class;
    }

    public finalforeach.cosmicreach.items.ItemStack getActualItemStack() {
        return ((VoidItemStack) itemStack).getMirror();
    }
}

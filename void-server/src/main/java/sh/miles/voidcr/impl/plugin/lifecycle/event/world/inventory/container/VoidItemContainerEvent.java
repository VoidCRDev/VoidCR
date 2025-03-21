package sh.miles.voidcr.impl.plugin.lifecycle.event.world.inventory.container;

import finalforeach.cosmicreach.items.containers.SlotContainer;
import sh.miles.voidcr.impl.plugin.lifecycle.event.VoidLifecycleEvent;
import sh.miles.voidcr.plugin.lifecycle.event.world.inventory.container.ItemContainerEvent;
import sh.miles.voidcr.server.Server;
import sh.miles.voidcr.world.inventory.container.ItemContainer;

public abstract class VoidItemContainerEvent extends VoidLifecycleEvent<Server> implements ItemContainerEvent {

    protected final ItemContainer container;

    public VoidItemContainerEvent(final Server context, SlotContainer container) {
        super(context);
        this.container = container.getVoidMirror();
    }

    @Override
    public ItemContainer getItemContainer() {
        return this.container;
    }
}

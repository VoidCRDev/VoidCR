package sh.miles.voidcr.impl.world.block.entity;

import sh.miles.voidcr.world.block.entity.BlockEntityDispenser;
import sh.miles.voidcr.world.inventory.container.ItemContainer;

public class VoidBlockEntityDispenser extends VoidBlockEntity<finalforeach.cosmicreach.blocks.blockentities.BlockEntityDispenser> implements BlockEntityDispenser {
    public VoidBlockEntityDispenser(final finalforeach.cosmicreach.blocks.blockentities.BlockEntityDispenser mirror) {
        super(mirror);
    }

    @Override
    public ItemContainer getItemContainer() {
        return mirror.slotContainer.getVoidMirror();
    }

    @Override
    public void shoot() {
        mirror.shootDispenser();
    }

    @Override
    public void shootNow() {
        mirror.shootDispenserNow();
    }

    @Override
    public boolean willShootNextTick() {
        return mirror.shootPending;
    }
}

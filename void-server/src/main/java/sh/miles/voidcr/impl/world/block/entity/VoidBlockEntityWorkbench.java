package sh.miles.voidcr.impl.world.block.entity;

import finalforeach.cosmicreach.blocks.blockentities.BlockEntityWorkbench;
import sh.miles.voidcr.world.inventory.container.ItemContainer;

public class VoidBlockEntityWorkbench extends VoidBlockEntity<BlockEntityWorkbench> implements sh.miles.voidcr.world.block.entity.BlockEntityWorkbench {
    public VoidBlockEntityWorkbench(final BlockEntityWorkbench mirror) {
        super(mirror);
    }

    @Override
    public ItemContainer getItemContainer() {
        return mirror.slotContainer.getVoidMirror();
    }
}

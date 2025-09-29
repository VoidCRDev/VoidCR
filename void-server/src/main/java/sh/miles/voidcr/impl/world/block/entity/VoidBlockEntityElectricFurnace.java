package sh.miles.voidcr.impl.world.block.entity;

import com.google.common.base.Preconditions;
import finalforeach.cosmicreach.blocks.blockentities.BlockEntityElectricFurnace;
import org.jspecify.annotations.NullMarked;
import sh.miles.voidcr.world.inventory.container.ItemContainer;

@NullMarked
public class VoidBlockEntityElectricFurnace extends VoidBlockEntity<BlockEntityElectricFurnace> implements sh.miles.voidcr.world.block.entity.BlockEntityElectricFurnace {

    public VoidBlockEntityElectricFurnace(final BlockEntityElectricFurnace mirror) {
        super(mirror);
    }

    @Override
    public int getProgressTicks() {
        return mirror.progressTicks;
    }

    @Override
    public int getMaxProgressTicks() {
        return mirror.MAX_PROGRESS_TICKS;
    }

    @Override
    public int getJouleCapacity() {
        return mirror.powerCapacityJoules;
    }

    @Override
    public void setJouleCapacity(final int capacity) throws IllegalArgumentException {
        Preconditions.checkArgument(capacity > 0, "The provided capacity must be more than zero");
        mirror.powerCapacityJoules = capacity;
        if (mirror.powerAmountJoules > mirror.powerCapacityJoules) {
            mirror.powerAmountJoules = mirror.powerCapacityJoules;
        }
    }

    @Override
    public int getJouleLevel() {
        return mirror.powerAmountJoules;
    }

    @Override
    public void setJouleLevel(final int level) throws IllegalArgumentException {
        Preconditions.checkArgument(level >= 0, "The provided level must be greater than or equal to zero");
        mirror.powerAmountJoules = level;
    }

    @Override
    public ItemContainer getItemContainer() {
        return mirror.slotContainer.getVoidMirror();
    }
}

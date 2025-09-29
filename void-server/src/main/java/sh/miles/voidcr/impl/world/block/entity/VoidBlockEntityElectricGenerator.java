package sh.miles.voidcr.impl.world.block.entity;

import com.google.common.base.Preconditions;
import finalforeach.cosmicreach.blocks.blockentities.BlockEntityElectricGenerator;
import org.jspecify.annotations.NullMarked;
import sh.miles.voidcr.world.inventory.container.ItemContainer;

@NullMarked
public class VoidBlockEntityElectricGenerator extends VoidBlockEntity<BlockEntityElectricGenerator> implements sh.miles.voidcr.world.block.entity.BlockEntityElectricGenerator {

    public VoidBlockEntityElectricGenerator(final BlockEntityElectricGenerator mirror) {
        super(mirror);
    }

    @Override
    public int getProgressTicks() {
        return mirror.fuelTicks;
    }

    @Override
    public void setProgressTicks(final int ticks) throws IllegalArgumentException {
        Preconditions.checkArgument(ticks >= 0, "the provided tick count must be greater than or equal to zero");
        Preconditions.checkArgument(ticks <= getMaxProgressTicks(), "The provided ticks is not less than getMaxProgressTicks() and it must be");
        mirror.fuelTicks = ticks;
    }

    @Override
    public int getMaxProgressTicks() {
        return mirror.maxFuelTicks;
    }

    @Override
    public void setMaxProgressTicks(final int ticks) throws IllegalArgumentException {
        Preconditions.checkArgument(ticks >= 0, "the provided tick count must be greater than or equal to zero");
        mirror.maxFuelTicks = ticks;
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

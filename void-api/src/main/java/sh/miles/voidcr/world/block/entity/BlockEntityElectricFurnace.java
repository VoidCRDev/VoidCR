package sh.miles.voidcr.world.block.entity;

import sh.miles.voidcr.trait.JoulePowered;
import sh.miles.voidcr.world.inventory.container.ItemContainerOwner;

public interface BlockEntityElectricFurnace extends BlockEntity, ItemContainerOwner, JoulePowered {

    /**
     * Gets the amount of ticks into the recipe the furnace currently is, this method will return 0 if no recipe is
     * active
     *
     * @return the amount of ticks in progress, or 0 if no recipe is started
     * @since 0.4.7
     */
    int getProgressTicks();

    /**
     * Gets the "destination" progress ticks as the recipe completes, once {@link #getProgressTicks()} reaches the
     * return of this value, the furnace will complete the recipe.
     * <p>
     * As of 0.3.26 all recipes return "64", for their value, while this is a constant it is recommended to use this
     * method because this could change in the future.
     *
     * @return the maximum progress ticks, or 0 if no recipe is started
     * @since 0.4.7
     */
    int getMaxProgressTicks();
}

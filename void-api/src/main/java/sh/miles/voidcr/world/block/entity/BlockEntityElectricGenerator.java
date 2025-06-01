package sh.miles.voidcr.world.block.entity;

import sh.miles.voidcr.trait.JoulePowered;
import sh.miles.voidcr.world.inventory.container.ItemContainerOwner;

/**
 * Represents the BlockEntity of ElectricGenerator
 *
 * @since 0.4.7
 */
public interface BlockEntityElectricGenerator extends BlockEntity, ItemContainerOwner, JoulePowered {
    /**
     * Gets the amount of progress towards the next power generation event
     *
     * @return the ticks occurred since {@link #getMaxProgressTicks()} was hit last
     * @since 0.4.7
     */
    int getProgressTicks();

    /**
     * Progress towards {@link #getMaxProgressTicks()}, when hit a power generation event occurs.
     *
     * @param ticks the ticks progressing
     * @throws IllegalArgumentException thrown if ticks is less than 0
     * @since 0.4.7
     */
    void setProgressTicks(int ticks) throws IllegalArgumentException;

    /**
     * Gets the maximum progress ticks that must occur before more power is generated
     *
     * @return the max progress ticks
     * @since 0.4.7
     */
    int getMaxProgressTicks();

    /**
     * Sets the amount of ticks that must happen before power is generated
     *
     * @param ticks the ticks that must occur until each power generation event
     * @throws IllegalArgumentException thrown if ticks is less than 0
     * @since 0.4.7
     */
    void setMaxProgressTicks(int ticks) throws IllegalArgumentException;
}

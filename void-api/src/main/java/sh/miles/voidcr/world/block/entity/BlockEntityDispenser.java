package sh.miles.voidcr.world.block.entity;

import sh.miles.voidcr.world.inventory.container.ItemContainerOwner;

public interface BlockEntityDispenser extends BlockEntity, ItemContainerOwner {

    /**
     * Shoots the dispenser, the next tick
     *
     * @since 0.4.15
     */
    void shoot();

    /**
     * Instantly shoots the laser projectile
     *
     * @since 0.4.15
     */
    void shootNow();

    /**
     * Gets whether or not this BlockEntity dispenser will shoot the next tick
     *
     * @return true if the dispenser will shoot the next tick, otherwise false
     * @since 0.4.15
     */
    boolean willShootNextTick();
}

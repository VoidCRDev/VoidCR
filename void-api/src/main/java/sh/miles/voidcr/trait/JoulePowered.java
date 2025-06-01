package sh.miles.voidcr.trait;

/**
 * Interface describing some object that can be powered by Joules
 *
 * @since 0.4.7
 */
public interface JoulePowered {
    /**
     * The total "capacity" of this powered source. Capacity describes total amount of joules that can be held
     *
     * @return the joule capacity
     * @since 0.4.7
     */
    int getJouleCapacity();

    /**
     * Sets the maximum capacity of this powered source. see {@link #getJouleCapacity()} for more information on
     * capacity.
     * <p>
     * Setting capacity to anything less than the current {@link #getJouleLevel()} will automatically shrink the joule
     * level to the same the given capacity.
     *
     * @param capacity the capacity to set.
     * @throws IllegalArgumentException thrown if the provided capacity is less than 1
     * @since 0.4.7
     */
    void setJouleCapacity(int capacity) throws IllegalArgumentException;

    /**
     * Gets the current battery level compared to the capacity
     *
     * @return the joule level
     * @since 0.4.7
     */
    int getJouleLevel();

    /**
     * Sets the current joule level.
     *
     * @param level the level
     * @throws IllegalArgumentException thrown if the provided level is greater than {@link #getJouleCapacity()}
     * @since 0.4.7
     */
    void setJouleLevel(int level) throws IllegalArgumentException;

    /**
     * Gets the percent that this joule powered object is currently powered.
     * <p>
     * This method finds the state of charge decimal (level / capacity)
     *
     * @return the state of charge for this object between 0 and 1
     * @since 0.4.7
     */
    default float getJouleChargePercentage() {
        return (float) getJouleLevel() / getJouleCapacity();
    }
}

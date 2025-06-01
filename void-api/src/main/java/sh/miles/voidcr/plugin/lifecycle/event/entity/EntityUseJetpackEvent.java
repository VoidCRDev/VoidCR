package sh.miles.voidcr.plugin.lifecycle.event.entity;

/**
 * Event triggered when an entity uses a jetpack
 *
 * @since 0.4.8
 */
public interface EntityUseJetpackEvent extends EntityEvent {
    /**
     * True if the entity is using a jetpack, otherwise false
     *
     * @return true or false
     * @since 0.4.8
     */
    boolean isUsingJetpack();
}

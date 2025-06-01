package sh.miles.voidcr.plugin.lifecycle.event.entity.pre;

import sh.miles.voidcr.plugin.lifecycle.event.LifecycleEvent;
import sh.miles.voidcr.plugin.lifecycle.event.entity.EntityUseJetpackEvent;
import sh.miles.voidcr.server.Server;

/**
 * Event triggered before an entity uses a jetpack
 *
 * @since 0.4.8
 */
public interface PreEntityUseJetpackEvent extends EntityUseJetpackEvent, LifecycleEvent<Server> {
    /**
     * Sets the status of jetpack using
     *
     * @param status true to be using the jetpack, otherwise false
     * @since 0.4.8
     */
    void setUsingJetpack(boolean status);
}

package sh.miles.voidcr.plugin.lifecycle.event.entity.post;

import sh.miles.voidcr.plugin.lifecycle.event.LifecycleEvent;
import sh.miles.voidcr.plugin.lifecycle.event.entity.EntityUseJetpackEvent;
import sh.miles.voidcr.server.Server;

/**
 * Event occurs after an entity uses a jetpack
 *
 * @since 0.4.8
 */
public interface PostEntityUseJetpackEvent extends EntityUseJetpackEvent, LifecycleEvent<Server> {
}

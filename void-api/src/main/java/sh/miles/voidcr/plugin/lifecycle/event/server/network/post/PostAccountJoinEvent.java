package sh.miles.voidcr.plugin.lifecycle.event.server.network.post;

import sh.miles.voidcr.entity.PlayerEntity;
import sh.miles.voidcr.plugin.lifecycle.event.LifecycleEvent;
import sh.miles.voidcr.plugin.lifecycle.event.server.network.AccountJoinEvent;
import sh.miles.voidcr.server.Server;

/**
 * Event that occurs after an account has fully joined the server and passed all checked
 *
 * @since 0.4.1
 */
public interface PostAccountJoinEvent extends AccountJoinEvent, LifecycleEvent<Server> {

    /**
     * Gets the player associated with the joined account
     *
     * @return the player
     * @since 0.4.1
     */
    PlayerEntity getPlayer();
}

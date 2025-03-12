package sh.miles.voidcr.plugin.lifecycle.event.server.network.pre;

import sh.miles.voidcr.plugin.lifecycle.event.LifecycleEvent;
import sh.miles.voidcr.plugin.lifecycle.event.server.network.AccountJoinEvent;
import sh.miles.voidcr.server.Server;

/**
 * An event that occurs before an account fully connects to the server. This event is run even for accounts that may be
 * banned, blacklisted or failed to authenticate as well.
 *
 * @since 0.4.1
 */
public interface PreAccountJoinEvent extends AccountJoinEvent, LifecycleEvent<Server> {

    /**
     * Kicks the account joining with this message
     *
     * @param message the message to kick the account with
     * @since 0.4.1
     */
    void kick(String message);

    /**
     * Gets whether or not this player is going to be kicked by another plugin calling {@link #kick(String)}
     *
     * @return true if the account is going to be kicked
     * @since 0.4.1
     */
    boolean isKicked();
}

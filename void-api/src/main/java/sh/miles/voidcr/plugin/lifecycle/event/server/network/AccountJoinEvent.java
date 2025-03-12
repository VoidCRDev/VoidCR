package sh.miles.voidcr.plugin.lifecycle.event.server.network;

import sh.miles.voidcr.server.network.Account;

/**
 * An event that occurs when an account attempts to join the server
 *
 * @since 0.4.1
 */
public interface AccountJoinEvent {

    /**
     * Gets the account that is attempting to join the server
     *
     * @return the account joining
     * @since 0.4.1
     */
    Account getAccount();

}

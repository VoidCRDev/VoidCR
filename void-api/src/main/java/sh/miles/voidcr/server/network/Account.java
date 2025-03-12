package sh.miles.voidcr.server.network;

import sh.miles.voidcr.entity.PlayerEntity;

/**
 * Represents an account that is connected to the server. Only {@link PlayerEntity} have an account associated with
 * them
 *
 * @since 0.4.1
 */
public interface Account {

    /**
     * Gets the account name
     * <p>
     * This method is NOT a unique identifier and should NEVER be used as an identifier see {@link #getIdentifier()}
     *
     * @return the account name
     * @since 0.4.1
     */
    String getName();

    /**
     * Gets the unique identifier of this account
     *
     * @return the identifier
     * @since 0.4.1
     */
    AccountIdentifier getIdentifier();
}

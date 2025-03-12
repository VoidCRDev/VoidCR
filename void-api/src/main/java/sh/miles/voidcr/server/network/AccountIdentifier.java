package sh.miles.voidcr.server.network;

import sh.miles.voidcr.server.VoidCR;
import sh.miles.voidcr.util.serialize.ByteSerializable;

/**
 * Represents a unique identifier for an account
 *
 * @since 0.4.1
 */
public interface AccountIdentifier extends ByteSerializable {
    /**
     * Deserializes an AccountIdentifier from bytes
     *
     * @param input the input
     * @return the identifier
     * @since 0.4.1
     */
    static AccountIdentifier fromBytes(byte[] input) {
        return VoidCR.getMagic().deserialize(AccountIdentifier.class, input);
    }
}

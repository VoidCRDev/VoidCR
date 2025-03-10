package sh.miles.voidcr.util;

import sh.miles.voidcr.server.VoidCR;

/**
 * Represents a key with a namespace and value like "namespace:value".
 *
 * @since 0.3.14
 */
public interface NamedKey {

    String COSMIC_REACH = "base";
    String VOID_CR = "void_cr";

    /**
     * Gets the key of this key e.g. the "value" portion of "namespace:value"
     *
     * @return the key of this key
     * @since 0.3.14
     */
    String getKey();

    /**
     * Gets specific namespace of this key e.g. the "namespace" portion of "namespace:key"
     *
     * @return the namespace of this key
     * @since 0.3.14
     */
    String getNamespace();

    /**
     * Creates a {@link NamedKey} from a provided namespace and key value.
     * <p>
     * neither namespace or keys should have anything that is not a letter, hyphen or underscore. [a-zA-Z_-]
     *
     * @param namespace the namespace
     * @param key       the key
     * @return a NamedKey
     * @throws IllegalArgumentException thrown if the parameters violates the naming restrictions
     * @since 0.3.14
     */
    static NamedKey key(final String namespace, final String key) throws IllegalArgumentException {
        return VoidCR.getMagic().createNamedKey(namespace, key);
    }

    /**
     * Creates a {@link NamedKey} from a provided namespace and key value.
     * <p>
     * neither namespace or keys should have anything that is not a letter, hyphen or underscore. [a-zA-Z_-]
     *
     * @param keyString the keyString of format "namespace:key"
     * @return the named key
     * @throws IllegalArgumentException thrown if the parameter violates the naming restrictions
     * @since 0.3.14
     */
    static NamedKey key(final String keyString) throws IllegalArgumentException {
        return VoidCR.getMagic().createNamedKey(keyString);
    }

    /**
     * Creates a {@link NamedKey} in Cosmic Reach's namespace of the given key
     * <p>
     * The key should not have anything that is not a letter, hyphen or underscore. [a-zA-Z_-]
     *
     * @param key the key of the {@link NamedKey}
     * @return the named key
     * @throws IllegalArgumentException thrown if the parameter violates the naming restrictions
     */
    static NamedKey cosmicReach(final String key) throws IllegalArgumentException {
        return VoidCR.getMagic().createNamedKey(COSMIC_REACH, key);
    }

    /**
     * Creates a {@link NamedKey} in VoidCr's namespace of the given key
     * <p>
     *     This key should not have anything that is not a letter, hyphen or underscore. [a-zA-Z_-]
     *
     * @param key the key of the {@link NamedKey}
     * @return the named key
     * @throws IllegalArgumentException thrown if the parameter violates the naming restrictions
     */
    static NamedKey voidcr(final String key) throws IllegalArgumentException {
        return VoidCR.getMagic().createNamedKey(VOID_CR, key);
    }
}

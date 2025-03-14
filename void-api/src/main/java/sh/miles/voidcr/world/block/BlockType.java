package sh.miles.voidcr.world.block;

import org.jspecify.annotations.Nullable;
import sh.miles.voidcr.server.registry.Registries;
import sh.miles.voidcr.util.Keyed;
import sh.miles.voidcr.util.NamedKey;

import java.util.Collection;
import java.util.Map;

/**
 * An interface represent block types
 *
 * @since 0.3.27
 */
public interface BlockType extends Keyed {

    /**
     * Gets a block state with the given key and value parameters
     *
     * @param parameterKey   the parameter key
     * @param parameterValue the parameter value
     * @return the state, or null if no state with the parameter was found
     * @since 0.3.27
     */
    @Nullable
    BlockState getBlockState(String parameterKey, Object parameterValue);

    /**
     * Gets a block state with at least the given parameters
     *
     * @param parameters the minimum parameters to have
     * @return the state, or null if no state with the parameters was found
     * @since 0.3.27
     */
    @Nullable
    BlockState getBlockState(Map<String, Object> parameters);

    /**
     * Gets a block state of this type with the following exact parameters
     *
     * @param parameters the parameters
     * @return the block state, or null if no block state with those parameters were found
     * @since 0.3.27
     */
    @Nullable
    BlockState getExactBlockState(Map<String, Object> parameters);

    /**
     * Gets all block states of this block type
     *
     * @return all common block states
     * @since 0.3.14
     */
    Collection<BlockState> getAllBlockStates();

    /**
     * Gets the default block state for this block type
     *
     * @return the default block state
     * @since 0.3.14
     */
    BlockState getDefaultBlockState();

    private static BlockType block(String key) {
        return Registries.BLOCK.getOrThrow(NamedKey.cosmicReach(key));
    }
}

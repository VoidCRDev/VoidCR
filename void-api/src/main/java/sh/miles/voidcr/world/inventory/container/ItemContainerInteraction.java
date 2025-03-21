package sh.miles.voidcr.world.inventory.container;

import sh.miles.voidcr.server.registry.Registries;
import sh.miles.voidcr.util.Keyed;
import sh.miles.voidcr.util.NamedKey;

/**
 * Represents a type of interaction that can be applied to an ItemContainer
 *
 * @since 0.4.1
 */
public interface ItemContainerInteraction extends Keyed {

    ItemContainerInteraction CURSOR_SWAP = interaction("cursor_swap");
    ItemContainerInteraction CURSOR_RIGHT = interaction("cursor_right");
    ItemContainerInteraction CURSOR_SPREAD = interaction("cursor_spread");
    ItemContainerInteraction CURSOR_TRASH = interaction("cursor_trash");

    private static ItemContainerInteraction interaction(String key) {
        return Registries.ITEM_CONTAINER_INTERACT.getOrThrow(NamedKey.cosmicReach(key));
    }
}

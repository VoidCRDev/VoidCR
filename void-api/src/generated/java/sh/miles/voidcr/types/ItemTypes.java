package sh.miles.voidcr.types;

import java.lang.String;
import sh.miles.voidcr.server.registry.Registries;
import sh.miles.voidcr.world.inventory.item.ItemKey;
import sh.miles.voidcr.world.inventory.item.ItemType;

/**
 * Generated class containing all default {@link ItemType}
 */
public interface ItemTypes {
    /**
     * Generated {@link ItemType} with the id "base:axe_aluminium"
     */
    ItemType AXE_ALUMINIUM = get("axe_aluminium");

    /**
     * Generated {@link ItemType} with the id "base:axe_iron"
     */
    ItemType AXE_IRON = get("axe_iron");

    /**
     * Generated {@link ItemType} with the id "base:axe_stone"
     */
    ItemType AXE_STONE = get("axe_stone");

    /**
     * Generated {@link ItemType} with the id "base:fluid_vacuum"
     */
    ItemType FLUID_VACUUM = get("fluid_vacuum");

    /**
     * Generated {@link ItemType} with the id "base:ingot_aluminium"
     */
    ItemType INGOT_ALUMINIUM = get("ingot_aluminium");

    /**
     * Generated {@link ItemType} with the id "base:ingot_gold"
     */
    ItemType INGOT_GOLD = get("ingot_gold");

    /**
     * Generated {@link ItemType} with the id "base:ingot_iron"
     */
    ItemType INGOT_IRON = get("ingot_iron");

    /**
     * Generated {@link ItemType} with the id "base:laser_gun"
     */
    ItemType LASER_GUN = get("laser_gun");

    /**
     * Generated {@link ItemType} with the id "base:latex"
     */
    ItemType LATEX = get("latex");

    /**
     * Generated {@link ItemType} with the id "base:medkit"
     */
    ItemType MEDKIT = get("medkit");

    /**
     * Generated {@link ItemType} with the id "base:medkit_gold"
     */
    ItemType MEDKIT_GOLD = get("medkit_gold");

    /**
     * Generated {@link ItemType} with the id "base:pickaxe_aluminium"
     */
    ItemType PICKAXE_ALUMINIUM = get("pickaxe_aluminium");

    /**
     * Generated {@link ItemType} with the id "base:pickaxe_iron"
     */
    ItemType PICKAXE_IRON = get("pickaxe_iron");

    /**
     * Generated {@link ItemType} with the id "base:pickaxe_stone"
     */
    ItemType PICKAXE_STONE = get("pickaxe_stone");

    /**
     * Generated {@link ItemType} with the id "base:rubber_ball"
     */
    ItemType RUBBER_BALL = get("rubber_ball");

    /**
     * Generated {@link ItemType} with the id "base:shovel_aluminium"
     */
    ItemType SHOVEL_ALUMINIUM = get("shovel_aluminium");

    /**
     * Generated {@link ItemType} with the id "base:shovel_iron"
     */
    ItemType SHOVEL_IRON = get("shovel_iron");

    /**
     * Generated {@link ItemType} with the id "base:shovel_stone"
     */
    ItemType SHOVEL_STONE = get("shovel_stone");

    /**
     * Generated {@link ItemType} with the id "base:stick"
     */
    ItemType STICK = get("stick");

    private static ItemType get(String key) {
        return Registries.ITEM.get(ItemKey.cosmicReach(key));
    }
}

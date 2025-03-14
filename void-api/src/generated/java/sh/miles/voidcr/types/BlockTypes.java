package sh.miles.voidcr.types;

import java.lang.String;
import sh.miles.voidcr.server.registry.Registries;
import sh.miles.voidcr.util.NamedKey;
import sh.miles.voidcr.world.block.BlockType;

/**
 * Generated class containing all default {@link BlockType}
 */
public interface BlockTypes {
    /**
     * Generated {@link BlockType} with the id "base:air"
     */
    BlockType AIR = get("air");

    /**
     * Generated {@link BlockType} with the id "base:aluminium_panel"
     */
    BlockType ALUMINIUM_PANEL = get("aluminium_panel");

    /**
     * Generated {@link BlockType} with the id "base:asphalt"
     */
    BlockType ASPHALT = get("asphalt");

    /**
     * Generated {@link BlockType} with the id "base:boombox"
     */
    BlockType BOOMBOX = get("boombox");

    /**
     * Generated {@link BlockType} with the id "base:bricks"
     */
    BlockType BRICKS = get("bricks");

    /**
     * Generated {@link BlockType} with the id "base:c4"
     */
    BlockType C4 = get("c4");

    /**
     * Generated {@link BlockType} with the id "base:cheese"
     */
    BlockType CHEESE = get("cheese");

    /**
     * Generated {@link BlockType} with the id "base:coal"
     */
    BlockType COAL = get("coal");

    /**
     * Generated {@link BlockType} with the id "base:coconut"
     */
    BlockType COCONUT = get("coconut");

    /**
     * Generated {@link BlockType} with the id "base:crate_wooden"
     */
    BlockType CRATE_WOODEN = get("crate_wooden");

    /**
     * Generated {@link BlockType} with the id "base:debug"
     */
    BlockType DEBUG = get("debug");

    /**
     * Generated {@link BlockType} with the id "base:dirt"
     */
    BlockType DIRT = get("dirt");

    /**
     * Generated {@link BlockType} with the id "base:furnace"
     */
    BlockType FURNACE = get("furnace");

    /**
     * Generated {@link BlockType} with the id "base:glass"
     */
    BlockType GLASS = get("glass");

    /**
     * Generated {@link BlockType} with the id "base:gold_block"
     */
    BlockType GOLD_BLOCK = get("gold_block");

    /**
     * Generated {@link BlockType} with the id "base:grass"
     */
    BlockType GRASS = get("grass");

    /**
     * Generated {@link BlockType} with the id "base:hazard"
     */
    BlockType HAZARD = get("hazard");

    /**
     * Generated {@link BlockType} with the id "base:ice"
     */
    BlockType ICE = get("ice");

    /**
     * Generated {@link BlockType} with the id "base:laser_emitter"
     */
    BlockType LASER_EMITTER = get("laser_emitter");

    /**
     * Generated {@link BlockType} with the id "base:leaves"
     */
    BlockType LEAVES = get("leaves");

    /**
     * Generated {@link BlockType} with the id "base:leaves_poplar"
     */
    BlockType LEAVES_POPLAR = get("leaves_poplar");

    /**
     * Generated {@link BlockType} with the id "base:light"
     */
    BlockType LIGHT = get("light");

    /**
     * Generated {@link BlockType} with the id "base:lunar_soil"
     */
    BlockType LUNAR_SOIL = get("lunar_soil");

    /**
     * Generated {@link BlockType} with the id "base:lunar_soil_packed"
     */
    BlockType LUNAR_SOIL_PACKED = get("lunar_soil_packed");

    /**
     * Generated {@link BlockType} with the id "base:magma"
     */
    BlockType MAGMA = get("magma");

    /**
     * Generated {@link BlockType} with the id "base:metal_panel"
     */
    BlockType METAL_PANEL = get("metal_panel");

    /**
     * Generated {@link BlockType} with the id "base:ore_bauxite"
     */
    BlockType ORE_BAUXITE = get("ore_bauxite");

    /**
     * Generated {@link BlockType} with the id "base:ore_gold"
     */
    BlockType ORE_GOLD = get("ore_gold");

    /**
     * Generated {@link BlockType} with the id "base:ore_iron"
     */
    BlockType ORE_IRON = get("ore_iron");

    /**
     * Generated {@link BlockType} with the id "base:rubber_block"
     */
    BlockType RUBBER_BLOCK = get("rubber_block");

    /**
     * Generated {@link BlockType} with the id "base:sand"
     */
    BlockType SAND = get("sand");

    /**
     * Generated {@link BlockType} with the id "base:sapling_poplar"
     */
    BlockType SAPLING_POPLAR = get("sapling_poplar");

    /**
     * Generated {@link BlockType} with the id "base:snow"
     */
    BlockType SNOW = get("snow");

    /**
     * Generated {@link BlockType} with the id "base:stone_basalt"
     */
    BlockType STONE_BASALT = get("stone_basalt");

    /**
     * Generated {@link BlockType} with the id "base:stone_gabbro"
     */
    BlockType STONE_GABBRO = get("stone_gabbro");

    /**
     * Generated {@link BlockType} with the id "base:stone_gravel"
     */
    BlockType STONE_GRAVEL = get("stone_gravel");

    /**
     * Generated {@link BlockType} with the id "base:stone_limestone"
     */
    BlockType STONE_LIMESTONE = get("stone_limestone");

    /**
     * Generated {@link BlockType} with the id "base:text_display"
     */
    BlockType TEXT_DISPLAY = get("text_display");

    /**
     * Generated {@link BlockType} with the id "base:torch"
     */
    BlockType TORCH = get("torch");

    /**
     * Generated {@link BlockType} with the id "base:tree_log"
     */
    BlockType TREE_LOG = get("tree_log");

    /**
     * Generated {@link BlockType} with the id "base:water"
     */
    BlockType WATER = get("water");

    /**
     * Generated {@link BlockType} with the id "base:wood_door"
     */
    BlockType WOOD_DOOR = get("wood_door");

    /**
     * Generated {@link BlockType} with the id "base:wood_planks"
     */
    BlockType WOOD_PLANKS = get("wood_planks");

    private static BlockType get(String key) {
        return Registries.BLOCK.get(NamedKey.cosmicReach(key));
    }
}

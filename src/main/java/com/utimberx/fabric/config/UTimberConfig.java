package com.utimberx.fabric.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class UTimberConfig {
    public boolean crouchDisable = true;
    public boolean treeFallingDamage = true;
    public boolean damageToolByLogCount = false;
    public boolean requireTool = true;
    public List<String> tools = new ArrayList<>();
    public boolean replantSapling = true;
    public List<String> replantableBlocks = new ArrayList<>();

    public int logsPerTick = 2;
    public int maxBlocks = 256;
    public int maxScanNodes = 20000;
    public Boolean enableNether = true;

    public Map<String, TreeDefinition> trees = new LinkedHashMap<>();

    public static UTimberConfig defaults() {
        UTimberConfig config = new UTimberConfig();
        config.tools = new ArrayList<>(Arrays.asList(
                "WOODEN_AXE",
                "STONE_AXE",
                "COPPER_AXE",
                "IRON_AXE",
                "GOLDEN_AXE",
                "DIAMOND_AXE",
                "NETHERITE_AXE"
        ));

        config.replantableBlocks = new ArrayList<>(Arrays.asList(
                "dirt",
                "grass_block",
                "podzol",
                "mycelium",
                "coarse_dirt",
                "rooted_dirt",
                "moss_block",
                "pale_moss_block",
                "netherrack",
                "warped_nylium",
                "crimson_nylium",
                "mud"
        ));

        Map<String, TreeDefinition> trees = new LinkedHashMap<>();

        trees.put("oak", new TreeDefinition(
                Arrays.asList("OAK_LOG", "STRIPPED_OAK_LOG"),
                Arrays.asList("OAK_LEAVES"),
                "OAK_SAPLING",
                0,
                6,
                false,
                2,
                4,
                4,
                12,
                false,
                false,
                false
        ));

        trees.put("fancy_oak", new TreeDefinition(
                Arrays.asList("OAK_LOG", "STRIPPED_OAK_LOG"),
                Arrays.asList("OAK_LEAVES"),
                "OAK_SAPLING",
                4,
                12,
                false,
                4,
                6,
                9,
                24,
                false,
                false,
                false
        ));

        trees.put("azalea", new TreeDefinition(
                Arrays.asList("OAK_LOG", "STRIPPED_OAK_LOG"),
                Arrays.asList("flowering_azalea_leaves", "azalea_leaves"),
                "azalea",
                4,
                6,
                false,
                3,
                4,
                4,
                12,
                false,
                false,
                false
        ));

        trees.put("birch", new TreeDefinition(
                Arrays.asList("BIRCH_LOG", "STRIPPED_BIRCH_LOG"),
                Arrays.asList("BIRCH_LEAVES"),
                "BIRCH_SAPLING",
                0,
                9,
                false,
                2,
                3,
                4,
                12,
                false,
                false,
                false
        ));

        trees.put("spruce", new TreeDefinition(
                Arrays.asList("SPRUCE_LOG", "STRIPPED_SPRUCE_LOG"),
                Arrays.asList("SPRUCE_LEAVES"),
                "SPRUCE_SAPLING",
                0,
                9,
                false,
                3,
                2,
                4,
                8,
                true,
                false,
                false
        ));

        trees.put("acacia", new TreeDefinition(
                Arrays.asList("ACACIA_LOG", "STRIPPED_ACACIA_LOG"),
                Arrays.asList("ACACIA_LEAVES"),
                "ACACIA_SAPLING",
                4,
                9,
                false,
                4,
                2,
                4,
                12,
                false,
                false,
                false
        ));

        trees.put("jungle", new TreeDefinition(
                Arrays.asList("JUNGLE_LOG", "STRIPPED_JUNGLE_LOG"),
                Arrays.asList("JUNGLE_LEAVES"),
                "JUNGLE_SAPLING",
                0,
                11,
                false,
                2,
                3,
                4,
                12,
                false,
                false,
                false
        ));

        trees.put("dark_oak", new TreeDefinition(
                Arrays.asList("DARK_OAK_LOG", "STRIPPED_DARK_OAK_LOG"),
                Arrays.asList("DARK_OAK_LEAVES"),
                "DARK_OAK_SAPLING",
                2,
                10,
                true,
                6,
                2,
                24,
                12,
                false,
                false,
                false
        ));

        trees.put("cherry", new TreeDefinition(
                Arrays.asList("CHERRY_LOG", "STRIPPED_CHERRY_LOG"),
                Arrays.asList("CHERRY_LEAVES"),
                "CHERRY_SAPLING",
                4,
                10,
                false,
                7,
                6,
                4,
                12,
                false,
                false,
                false
        ));

        trees.put("pale_oak", new TreeDefinition(
                Arrays.asList("PALE_OAK_LOG", "STRIPPED_PALE_OAK_LOG"),
                Arrays.asList("PALE_OAK_LEAVES"),
                "PALE_OAK_SAPLING",
                3,
                10,
                true,
                5,
                2,
                24,
                12,
                false,
                false,
                false
        ));

        trees.put("large_spruce", new TreeDefinition(
                Arrays.asList("SPRUCE_LOG", "STRIPPED_SPRUCE_LOG"),
                Arrays.asList("SPRUCE_LEAVES"),
                "SPRUCE_SAPLING",
                1,
                30,
                true,
                6,
                3,
                40,
                9,
                false,
                true,
                false
        ));

        trees.put("large_jungle", new TreeDefinition(
                Arrays.asList("JUNGLE_LOG", "STRIPPED_JUNGLE_LOG"),
                Arrays.asList("JUNGLE_LEAVES"),
                "JUNGLE_SAPLING",
                5,
                30,
                true,
                9,
                3,
                40,
                9,
                false,
                true,
                false
        ));

        trees.put("red_mushroom", new TreeDefinition(
                Arrays.asList("MUSHROOM_STEM"),
                Arrays.asList("RED_MUSHROOM_BLOCK"),
                "red_mushroom",
                0,
                10,
                false,
                2,
                5,
                4,
                12,
                false,
                true,
                false
        ));

        trees.put("brown_mushroom", new TreeDefinition(
                Arrays.asList("MUSHROOM_STEM"),
                Arrays.asList("BROWN_MUSHROOM_BLOCK"),
                "brown_mushroom",
                0,
                10,
                false,
                3,
                0,
                4,
                12,
                false,
                false,
                false
        ));

        trees.put("warped_fungus", new TreeDefinition(
                Arrays.asList("warped_stem"),
                Arrays.asList("warped_wart_block", "shroomlight"),
                "warped_fungus",
                0,
                12,
                false,
                3,
                8,
                4,
                12,
                false,
                true,
                false
        ));

        trees.put("crimson_fungus", new TreeDefinition(
                Arrays.asList("crimson_stem"),
                Arrays.asList("nether_wart_block", "shroomlight"),
                "crimson_fungus",
                0,
                12,
                false,
                3,
                8,
                4,
                12,
                false,
                true,
                false
        ));

        trees.put("large_crimson_fungus", new TreeDefinition(
                Arrays.asList("crimson_stem"),
                Arrays.asList("nether_wart_block", "shroomlight"),
                "crimson_fungus",
                2,
                12,
                false,
                4,
                8,
                24,
                12,
                false,
                true,
                false
        ));

        trees.put("mangrove", new TreeDefinition(
                Arrays.asList("mangrove_roots", "muddy_mangrove_roots", "mangrove_log", "stripped_mangrove_log"),
                Arrays.asList("mangrove_leaves"),
                "mangrove_propagule",
                8,
                21,
                false,
                8,
                25,
                12,
                24,
                false,
                false,
                true
        ));

        config.trees = trees;
        return config;
    }
}

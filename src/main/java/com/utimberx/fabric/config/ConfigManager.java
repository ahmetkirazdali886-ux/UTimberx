package com.utimberx.fabric.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public final class ConfigManager {
    private static final String CONFIG_FILE_NAME = "utimber.json";
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    private ConfigManager() {
    }

    public static UTimberConfig loadOrCreate(Logger logger) {
        Path configPath = getConfigPath();
        if (!Files.exists(configPath)) {
            UTimberConfig defaults = UTimberConfig.defaults();
            save(logger, defaults);
            return defaults;
        }

        UTimberConfig loaded = load(logger, configPath);
        if (loaded == null) {
            UTimberConfig defaults = UTimberConfig.defaults();
            save(logger, defaults);
            return defaults;
        }

        applyMissingDefaults(loaded, UTimberConfig.defaults());
        if (!isValid(loaded)) {
            backupBroken(logger, configPath);
            UTimberConfig defaults = UTimberConfig.defaults();
            save(logger, defaults);
            return defaults;
        }

        return loaded;
    }

    public static void save(Logger logger, UTimberConfig config) {
        Path configPath = getConfigPath();
        try {
            Files.createDirectories(configPath.getParent());
            try (BufferedWriter writer = Files.newBufferedWriter(configPath, StandardCharsets.UTF_8)) {
                GSON.toJson(config, writer);
            }
        } catch (IOException exception) {
            logger.error("Failed to save UTimber config to {}", configPath, exception);
        }
    }

    private static UTimberConfig load(Logger logger, Path configPath) {
        try (BufferedReader reader = Files.newBufferedReader(configPath, StandardCharsets.UTF_8)) {
            return GSON.fromJson(reader, UTimberConfig.class);
        } catch (JsonSyntaxException | JsonIOException exception) {
            logger.error("Malformed UTimber config at {}", configPath, exception);
            backupBroken(logger, configPath);
        } catch (IOException exception) {
            logger.error("Failed to read UTimber config at {}", configPath, exception);
        }
        return null;
    }

    private static void backupBroken(Logger logger, Path configPath) {
        Path brokenPath = configPath.resolveSibling(CONFIG_FILE_NAME + ".broken");
        try {
            Files.createDirectories(configPath.getParent());
            if (Files.exists(configPath)) {
                Files.copy(configPath, brokenPath, StandardCopyOption.REPLACE_EXISTING);
                logger.error("Wrote broken config copy to {}", brokenPath);
            }
        } catch (IOException exception) {
            logger.error("Failed to write broken config copy to {}", brokenPath, exception);
        }
    }

    private static void applyMissingDefaults(UTimberConfig config, UTimberConfig defaults) {
        if (config.tools == null || config.tools.isEmpty()) {
            config.tools = defaults.tools;
        }
        if (config.replantableBlocks == null || config.replantableBlocks.isEmpty()) {
            config.replantableBlocks = defaults.replantableBlocks;
        }
        if (config.logsPerTick <= 0) {
            config.logsPerTick = defaults.logsPerTick;
        }
        if (config.maxBlocks <= 0) {
            config.maxBlocks = defaults.maxBlocks;
        }
        if (config.maxScanNodes <= 0) {
            config.maxScanNodes = defaults.maxScanNodes;
        }
        if (config.enableNether == null) {
            config.enableNether = defaults.enableNether;
        }
    }

    private static boolean isValid(UTimberConfig config) {
        if (config == null) {
            return false;
        }
        if (config.trees == null || config.trees.isEmpty()) {
            return false;
        }
        for (TreeDefinition definition : config.trees.values()) {
            if (definition == null) {
                return false;
            }
            if (definition.getLogs().isEmpty() || definition.getLeaves().isEmpty()) {
                return false;
            }
            if (definition.getSapling() == null || definition.getSapling().trim().isEmpty()) {
                return false;
            }
            if (definition.getLogDistanceX() < 0 || definition.getLogDistanceY() < 0) {
                return false;
            }
            if (definition.getLeafDistanceX() < 0 || definition.getLeafDistanceY() < 0) {
                return false;
            }
            if (definition.getMinLogs() < 0 || definition.getMinLeaves() < 0) {
                return false;
            }
        }
        return true;
    }

    private static Path getConfigPath() {
        return FabricLoader.getInstance().getConfigDir().resolve(CONFIG_FILE_NAME);
    }
}

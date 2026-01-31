package com.utimberx.fabric.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class TreeRegistry {
    private final Map<String, TreeDefinition> trees;
    private final Map<String, List<TreeDefinition>> byLog;

    public TreeRegistry(Map<String, TreeDefinition> trees) {
        Map<String, TreeDefinition> safeTrees = new LinkedHashMap<>(trees);
        this.trees = Collections.unmodifiableMap(safeTrees);
        this.byLog = buildIndex(safeTrees);
    }

    public Map<String, TreeDefinition> getTrees() {
        return trees;
    }

    public List<TreeDefinition> getByLog(String logId) {
        if (logId == null) {
            return Collections.emptyList();
        }
        return byLog.getOrDefault(logId.toLowerCase(Locale.ROOT), Collections.emptyList());
    }

    private Map<String, List<TreeDefinition>> buildIndex(Map<String, TreeDefinition> source) {
        Map<String, List<TreeDefinition>> index = new LinkedHashMap<>();
        for (TreeDefinition definition : source.values()) {
            for (String log : definition.getLogs()) {
                String key = log.toLowerCase(Locale.ROOT);
                index.computeIfAbsent(key, ignored -> new ArrayList<>()).add(definition);
            }
        }
        return index;
    }
}

package com.utimberx.fabric.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class TreeDefinition {
    private final List<String> logs;
    private final List<String> leaves;
    private final String sapling;
    private final int logDistanceX;
    private final int logDistanceY;
    private final boolean largeLog;
    private final int leafDistanceX;
    private final int leafDistanceY;
    private final int minLogs;
    private final int minLeaves;
    private final boolean separateLeaves;
    private final boolean diagonalLeaves;
    private final boolean downwardLogs;

    public TreeDefinition(
            List<String> logs,
            List<String> leaves,
            String sapling,
            int logDistanceX,
            int logDistanceY,
            boolean largeLog,
            int leafDistanceX,
            int leafDistanceY,
            int minLogs,
            int minLeaves,
            boolean separateLeaves,
            boolean diagonalLeaves,
            boolean downwardLogs
    ) {
        this.logs = new ArrayList<>(Objects.requireNonNull(logs, "logs"));
        this.leaves = new ArrayList<>(Objects.requireNonNull(leaves, "leaves"));
        this.sapling = Objects.requireNonNull(sapling, "sapling");
        this.logDistanceX = logDistanceX;
        this.logDistanceY = logDistanceY;
        this.largeLog = largeLog;
        this.leafDistanceX = leafDistanceX;
        this.leafDistanceY = leafDistanceY;
        this.minLogs = minLogs;
        this.minLeaves = minLeaves;
        this.separateLeaves = separateLeaves;
        this.diagonalLeaves = diagonalLeaves;
        this.downwardLogs = downwardLogs;
    }

    public List<String> getLogs() {
        return Collections.unmodifiableList(logs);
    }

    public List<String> getLeaves() {
        return Collections.unmodifiableList(leaves);
    }

    public String getSapling() {
        return sapling;
    }

    public int getLogDistanceX() {
        return logDistanceX;
    }

    public int getLogDistanceY() {
        return logDistanceY;
    }

    public boolean isLargeLog() {
        return largeLog;
    }

    public int getLeafDistanceX() {
        return leafDistanceX;
    }

    public int getLeafDistanceY() {
        return leafDistanceY;
    }

    public int getMinLogs() {
        return minLogs;
    }

    public int getMinLeaves() {
        return minLeaves;
    }

    public boolean isSeparateLeaves() {
        return separateLeaves;
    }

    public boolean isDiagonalLeaves() {
        return diagonalLeaves;
    }

    public boolean isDownwardLogs() {
        return downwardLogs;
    }
}

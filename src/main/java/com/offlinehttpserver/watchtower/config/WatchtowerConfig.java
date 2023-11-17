package com.offlinehttpserver.watchtower.config;

import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;

public abstract class WatchtowerConfig {

    public static final BarColor DAY_BAR_COLOR = BarColor.YELLOW;

    public static final BarColor NIGHT_BAR_COLOR = BarColor.PURPLE;

    public static final BarStyle BAR_STYLE = BarStyle.SOLID;

    public static final String BAR_BASE_TITLE = "Time";

    public static final String WORLD_NAME = "world";

    public static final long THREAD_START_DELAY = 0L;

    public static final long THREAD_RUN_INTERVAL = 20L;

    public static final int SPLIT = 13_000;

    public static final int MIN_BAR_VALUE = 0;

    public static final int MAX_BAR_VALUE = 24_000;

}

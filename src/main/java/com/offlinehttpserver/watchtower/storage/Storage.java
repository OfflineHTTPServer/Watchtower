package com.offlinehttpserver.watchtower.storage;

import com.offlinehttpserver.watchtower.config.WatchtowerConfig;
import org.bukkit.Bukkit;
import org.bukkit.boss.BossBar;

public class Storage {

    public static final BossBar dayWatchBar = Bukkit.getServer().createBossBar(
            WatchtowerConfig.BAR_BASE_TITLE,
            WatchtowerConfig.DAY_BAR_COLOR,
            WatchtowerConfig.BAR_STYLE
    );

}

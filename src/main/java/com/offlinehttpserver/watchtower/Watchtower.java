package com.offlinehttpserver.watchtower;

import com.offlinehttpserver.watchtower.storage.Storage;
import com.offlinehttpserver.watchtower.command.Watch;
import com.offlinehttpserver.watchtower.config.WatchtowerConfig;
import com.offlinehttpserver.watchtower.thread.PluginRunnable;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Watchtower extends JavaPlugin {

    PluginRunnable bossBarManager = new PluginRunnable();

    @Override
    public void onEnable() {
        getCommand(Watch.commandName).setExecutor(new Watch());
        bossBarManager.setPayload(() -> {

            long time = Bukkit.getWorld(WatchtowerConfig.WORLD_NAME).getTime();

            if (time <= WatchtowerConfig.SPLIT) {
                Storage.dayWatchBar.setColor(WatchtowerConfig.DAY_BAR_COLOR);
                Storage.dayWatchBar.setProgress((double) time / WatchtowerConfig.SPLIT);
                return;
            }

            Storage.dayWatchBar.setColor(WatchtowerConfig.NIGHT_BAR_COLOR);
            Storage.dayWatchBar.setProgress((double) (time - WatchtowerConfig.SPLIT) / (WatchtowerConfig.MAX_BAR_VALUE - WatchtowerConfig.SPLIT));

        }, WatchtowerConfig.THREAD_START_DELAY, WatchtowerConfig.THREAD_RUN_INTERVAL);
        bossBarManager.start();
    }

    @Override
    public void onDisable() {
        bossBarManager.stop();
    }
}

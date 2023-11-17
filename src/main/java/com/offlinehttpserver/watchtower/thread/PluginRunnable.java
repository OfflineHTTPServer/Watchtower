package com.offlinehttpserver.watchtower.thread;

import com.offlinehttpserver.watchtower.Watchtower;
import com.offlinehttpserver.watchtower.lambda.TakesNoneReturnsVoid;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class PluginRunnable {

    public TakesNoneReturnsVoid lambda = () -> {Bukkit.getConsoleSender().sendMessage("RUNNABLE ACTIVE");};

    public int taskId = -1;

    public long threadStartDelay = 0L;

    public long threadRunInterval = 0L;

    public PluginRunnable() {}

    public void setPayload(
            TakesNoneReturnsVoid lambda,
            long threadStartDelay,
            long threadRunInterval
    ) {
        this.threadStartDelay = threadStartDelay;
        this.threadRunInterval = threadRunInterval;
        this.lambda = lambda;
    }

    public void start() {
        taskId = new BukkitRunnable() {

            @Override
            public void run() {
                lambda.F();
            }

        }.runTaskTimer(Watchtower.getProvidingPlugin(Watchtower.class), threadStartDelay, threadRunInterval).getTaskId();
    }

    public void stop() {
        ThreadInfo.scheduler.cancelTask(taskId);
    }

}

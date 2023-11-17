package com.offlinehttpserver.watchtower.command;

import com.offlinehttpserver.watchtower.storage.Storage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Watch implements CommandExecutor {

    public static String commandName = "watch";

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player)) {
            return false;
        }

        Player player = (Player) sender;

        if (Storage.dayWatchBar.getPlayers().contains(player)) {
            Storage.dayWatchBar.removePlayer(player);
            return true;
        }

        Storage.dayWatchBar.addPlayer(player);

        return true;
    }
}

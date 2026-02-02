package hu.jgj52.amethystCraft.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class DuelCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {

        if (!(commandSender instanceof Player player1)) return true;

        if (strings.length != 1) {
            player1.sendMessage("§7Usage: /duel <player>");
            return true;
        }

        Player player2 = Bukkit.getPlayer(strings[0]);
        if (player2 == null || !player2.isOnline()){
            player1.sendMessage(strings[0] + " is not online!");
            return true;
        }



        return true;
    }
}

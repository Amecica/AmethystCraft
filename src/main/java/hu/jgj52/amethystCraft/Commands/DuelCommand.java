package hu.jgj52.amethystCraft.Commands;

import hu.jgj52.amethystCraft.Utils.NewConfig;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

import static hu.jgj52.amethystCraft.Main.plugin;

public class DuelCommand implements CommandExecutor, TabExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String s, @NotNull String @NotNull [] args) {

        if (!(sender instanceof Player player1)) {

            sender.sendMessage(NewConfig.getString("console.player"));
            return true;

        }

        if (args.length != 1) {

            player1.sendMessage(NewConfig.getString("player.args").replace("%usage%", "/duel <player>"));
            return true;

        }

        Player player2 = Bukkit.getPlayer(args[0]);
        if (player2 == null || !player2.isOnline()){
            player1.sendMessage(NewConfig.getString("player.offline").replace("%player%", args[0]));
            return true;
        }



        return true;

    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String s, @NotNull String @NotNull [] args) {

        if (sender.hasPermission("ametiszt.banned")) return List.of();
        List<String> playerNames = new ArrayList<>();

        for (Player player : Bukkit.getOnlinePlayers()) playerNames.add(player.getName());

        switch (args.length) {

            case 1:

                return playerNames;

            default:

                return List.of();

        }

    }

}

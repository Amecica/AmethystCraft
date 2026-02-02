package hu.jgj52.amethystCraft.Commands;

import hu.jgj52.amethystCraft.Duel.DuelManager;
import hu.jgj52.amethystCraft.Kit.Kit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class TestCommand implements CommandExecutor {



    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {

        if (!(commandSender instanceof Player player)) return true;

        DuelManager.countdown(player);

        player.getInventory().setContents(Kit.of("1").getContent(player));

        return true;
    }
}

package hu.jgj52.amethystCraft.Duel;

import hu.jgj52.amethystCraft.AmethystCraft;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.title.TitlePart;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;



import static hu.jgj52.amethystCraft.AmethystCraft.plugin;

public class DuelManager {

    public void startDuel(Player player1, Player player2){

        countdown(player1);
        countdown(player2);

    }

    public static void countdown(Player player){
        int maxSeconds = plugin.getConfig().getInt("countdown", 5);
        int second = maxSeconds;
        int ticks = 0;
        for (int i = 0; i < maxSeconds+1; i++){
            boolean isLastSecond = second == 0;
            Component title = isLastSecond ? Component.text("FIGHT!") : Component.text(String.valueOf(second));
            Bukkit.getScheduler().runTaskLater(plugin, () -> {
                player.sendTitlePart(TitlePart.TITLE, title);
                player.playSound(player, Sound.BLOCK_NOTE_BLOCK_PLING, 1, isLastSecond ? 2 : 1);
            }, ticks);
            player.sendMessage("-");
            player.sendMessage("second:"+second);
            player.sendMessage("isLastSecond:"+isLastSecond);
            player.sendMessage("ticks:"+ticks);
            player.sendMessage("maxSeconds:"+maxSeconds);
            player.sendMessage("-");
            second--;
            ticks+=20;
        }
    }

}

package hu.jgj52.amethystCraft.Duel;

import hu.jgj52.amethystCraft.AmethystCraft;
import hu.jgj52.amethystCraft.Commands.DuelCommand;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.title.Title;
import net.kyori.adventure.title.TitlePart;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;


import java.time.Duration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static hu.jgj52.amethystCraft.AmethystCraft.plugin;

public class DuelManager {

    public static Set<Duel> duels = new HashSet<>();
    public static Set<DuelRequest> duelRequests = new HashSet<>();

    public void startDuel(Player player1, Player player2){

        countdown(player1);
        countdown(player2);

        Duel duel = new Duel(player1, player2);
        duels.add(duel);


    }

    public void sendDuelRequest(Player player1, Player player2){
        DuelRequest duelRequest = new DuelRequest(player1, player2);
        duelRequests.add(duelRequest);
        player1.sendMessage("§7Duel request sent!");
        player2.sendMessage(player1 + "§7 has sent you a duel request!");
    }

    public Duel getDuel(Player player){
        for (Duel duel : duels) if (duel.getPlayer1().equals(player) || duel.getPlayer2().equals(player)) return duel;
        return null;
    }


    public static void countdown(Player player){
        int maxSeconds = plugin.getConfig().getInt("countdown", 5);
        TextColor color = TextColor.fromHexString(plugin.getConfig().getString("color", "dea431"));
        int second = maxSeconds;
        int ticks = 0;
        for (int i = 0; i < maxSeconds+1; i++){
            boolean isLastSecond = second == 0;
            Component titleComponent = isLastSecond ? Component.text("FIGHT!").color(color) : Component.text(String.valueOf(second)).color(color);
            Bukkit.getScheduler().runTaskLater(plugin, () -> {

                Title title = Title.title(titleComponent, Component.empty(), Title.Times.times(
                        Duration.ofMillis(0),
                        Duration.ofMillis(1000),
                        Duration.ofMillis(500)));

                player.showTitle(title);
                player.playSound(player, Sound.BLOCK_NOTE_BLOCK_PLING, 1, isLastSecond ? 2 : 1);
            }, ticks);
            second--;
            ticks+=20;
        }
    }

}

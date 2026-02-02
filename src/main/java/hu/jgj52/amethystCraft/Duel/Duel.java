package hu.jgj52.amethystCraft.Duel;

import org.bukkit.entity.Player;

public class Duel {

    private Player player1;
    private Player player2;

    public Duel(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
    }

    public Player getPlayer1(){
        return player1;
    }

    public Player getPlayer2(){
        return player2;
    }

}

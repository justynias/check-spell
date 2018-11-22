package pt.ubi.di.pmd.check_spell_game.Model;

import pt.ubi.di.pmd.check_spell_game.DataProvider.PlayerProvider;

public class Game {

    private Player currentPlayer;
    private SingleRound currentRoud;
    private int points;

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public SingleRound getCurrentRoud() {
        return currentRoud;
    }

    public void setCurrentRoud(SingleRound currentRoud) {
        this.currentRoud = currentRoud;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    private int level;

public Game(){
    this.currentPlayer=PlayerProvider.readJson();
    points=0;
    level=0;
    currentRoud=new SingleRound();
}


}

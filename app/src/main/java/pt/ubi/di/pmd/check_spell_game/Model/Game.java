package pt.ubi.di.pmd.check_spell_game.Model;

import pt.ubi.di.pmd.check_spell_game.DataProvider.PlayerProvider;
import pt.ubi.di.pmd.check_spell_game.DataProvider.WordProvider;

public class Game {  //need to add the high score functionality-> check, show the user, share, save to file

    private Player currentPlayer;
    private SingleRound currentRound;
    private int points;
    private WordProvider wordProvider;
    private int level;


    public Player getCurrentPlayer() {
        return currentPlayer;
    }


    public SingleRound getCurrentRoud() {
        return currentRound;
    }


    public int getPoints() {
        return points;
    }


    public int getLevel() {
        return level;
    }


public Game(){
    this.currentPlayer=PlayerProvider.readJson();
    points=0;
    level=0;
    this.wordProvider=new WordProvider();
}


public void loadRound(){
    currentRound=new SingleRound(this.wordProvider);
}

public void checkRound(String answer){

    currentRound.setPlayerAnswer(answer);
    currentRound.incrementTryNumber();

    if(currentRound.isCompleted()){
        points+=100/currentRound.getTryNumber();

        if(points%1000==0)
        {
            level++;
        }
    }

}

}

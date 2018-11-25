package pt.ubi.di.pmd.check_spell_game.Model;

import android.util.Log;

import pt.ubi.di.pmd.check_spell_game.DataProvider.PlayerProvider;
import pt.ubi.di.pmd.check_spell_game.DataProvider.WordProvider;

public class Game {

    private Player currentPlayer;
    private SingleRound currentRound;
    private int points;

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    private WordProvider wordProvider;
    private int level;
    private boolean isRecordBroken;  // need another solution



    public boolean isRecordBroken() {
        return isRecordBroken;
    }



    public SingleRound getCurrentRound() {
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
    Log.d("PLAYER", currentPlayer.toString());
    points=0;
    level=0;
    this.wordProvider=new WordProvider();
    isRecordBroken=false;
}


public void loadRound(){
    currentRound=new SingleRound(this.wordProvider);
    isRecordBroken=false;
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
        if(points>currentPlayer.getBestScore())
        {
            currentPlayer.setBestScore(points);
            PlayerProvider.saveToJson(currentPlayer);
            Log.d("SCORE", "high score");
            isRecordBroken=true;
        }
    }

}

    public void savePlayer(String playerName){



        if(!playerName.equals(currentPlayer.getName()))
        {

            currentPlayer=new Player();
            currentPlayer.setName(playerName);
            PlayerProvider.saveToJson(currentPlayer);
        }





    }
}

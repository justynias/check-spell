package pt.ubi.di.pmd.check_spell_game.Model;

import pt.ubi.di.pmd.check_spell_game.DataProvider.PlayerProvider;
import pt.ubi.di.pmd.check_spell_game.DataProvider.WordProvider;

public class Game implements GameInterface{

    private Player currentPlayer;
    private SingleRound currentRound;
    private PlayerProvider playerProvider;
    private WordProvider wordProvider;
    private int points;
    private int level;
    private boolean isRecordBroken;  // need another solution


    public Game(){
        playerProvider= new PlayerProvider();
        currentPlayer=playerProvider.readJson();
        points=0;
        level=0;
        wordProvider=new WordProvider();
        isRecordBroken=false;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

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



public void loadRound(){
    currentRound=new SingleRound(this.wordProvider);
    isRecordBroken=false;
}

public void checkRound(String answer){

    currentRound.incrementTryNumber();
    currentRound.setPlayerAnswer(answer);

    if(currentRound.isCompleted()){
        points+=100/currentRound.getTryNumber();

        if(points%1000==0)
        {
            level++;
        }
        if(points>currentPlayer.getBestScore())
        {
            currentPlayer.setBestScore(points);
            playerProvider.saveToJson(currentPlayer);
            isRecordBroken=true;
        }
    }

}

    public void savePlayer(String playerName){

        if(!playerName.equals(currentPlayer.getName()))
        {

            currentPlayer=new Player();
            currentPlayer.setName(playerName);
            playerProvider.saveToJson(currentPlayer);
        }

    }
}

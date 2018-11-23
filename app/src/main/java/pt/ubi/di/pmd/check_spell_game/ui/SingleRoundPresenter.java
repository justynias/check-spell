package pt.ubi.di.pmd.check_spell_game.ui;
import android.util.Log;

import pt.ubi.di.pmd.check_spell_game.Model.Game;
import pt.ubi.di.pmd.check_spell_game.Model.SingleRound;

public class SingleRoundPresenter {

    SingleRoundActivity view;
    Game gameModel;
    SingleRound currentRound;


    SingleRoundPresenter(SingleRoundActivity view){
        this.view=view;
        gameModel=new Game();

        Log.d("LOGGED_PLAYER", gameModel.getCurrentPlayer().getName());
       loadRound();

    }


    public void loadRound(){
        view.cleanAnswerET();
        gameModel.loadRound();
        currentRound=gameModel.getCurrentRoud();
        this.view.setWord1TextView(currentRound.getDividedWord1());
        this.view.setWord2TextView(currentRound.getDividedWord2());
    }

    public void updateScore(){
        //set level and points

    }

    public void checkAnswer(String answer) {
        gameModel.checkRound(answer);

        Log.d("WYNIK", String.valueOf(gameModel.getLevel()));
        Log.d("WYNIK", String.valueOf(gameModel.getPoints()));

        //updateScore()

        if(currentRound.isCompleted()){
            view.setNextButtonVisible();
            view.setCheckButtonDisable();
            view.setAnswerETdisable();

        }
        else {
            if(currentRound.isSkipable()){
                view.setNextButtonVisible();
            }
            view.cleanAnswerET();

        }
        

    }
}

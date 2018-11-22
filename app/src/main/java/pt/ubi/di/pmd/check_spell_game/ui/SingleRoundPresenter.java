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
        //then change in model the round
        gameModel.loadRoud();
        currentRound=gameModel.getCurrentRoud();
        this.view.setword1TextView(currentRound.getDividedWord1());
        this.view.setword2TextView(currentRound.getDividedWord2());
        //this.view.setword1TextView("DUPS");

    }

}

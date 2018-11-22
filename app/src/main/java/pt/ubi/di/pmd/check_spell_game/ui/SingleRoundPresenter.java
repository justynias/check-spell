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
        currentRound=gameModel.getCurrentRoud();
        Log.d("LOGGED_PLAYER", gameModel.getCurrentPlayer().getName());

    }


    public void loadRound(){

    }

}

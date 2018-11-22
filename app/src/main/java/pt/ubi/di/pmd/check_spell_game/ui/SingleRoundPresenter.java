package pt.ubi.di.pmd.check_spell_game.ui;
import android.util.Log;

import pt.ubi.di.pmd.check_spell_game.Model.Game;

public class SingleRoundPresenter {

    SingleRoundActivity view;
    Game gameModel;


    SingleRoundPresenter(SingleRoundActivity view){
        this.view=view;

        gameModel=new Game();
        Log.d("LOGGED_PLAYER", gameModel.getCurrentPlayer().getName());

    }


    public void loadRound(){

    }

}

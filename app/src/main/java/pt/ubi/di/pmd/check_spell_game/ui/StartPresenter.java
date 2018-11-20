package pt.ubi.di.pmd.check_spell_game.ui;


import android.util.Log;

import pt.ubi.di.pmd.check_spell_game.DataProvider.JsonUtil;
import pt.ubi.di.pmd.check_spell_game.Model.Player;

public class StartPresenter {

    StartActivity view; // not null between onResume() and onPause()
    Player playerModel;


public StartPresenter(StartActivity view){

    this.view=view;
    playerModel= new Player();

}

    public void startButtonClicked() {
        view.navigateToGame();

    }

    public void savePlayer(String name){

    //validation!!
        playerModel.setName(name);
      // write-> JsonUtil.toJSon(playerModel);
        Log.d("JSON", JsonUtil.toJSon(playerModel));
       
    }
}

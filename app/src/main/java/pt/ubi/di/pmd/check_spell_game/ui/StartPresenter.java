package pt.ubi.di.pmd.check_spell_game.ui;

import android.util.Log;

import pt.ubi.di.pmd.check_spell_game.App;
import pt.ubi.di.pmd.check_spell_game.DataProvider.PlayerProvider;
import pt.ubi.di.pmd.check_spell_game.Model.Player;

public class StartPresenter {

    StartActivity view; // not null between onResume() and onPause()
    Player playerModel;

    public Player getPlayerModel() {
        return playerModel;
    }

    public StartPresenter(StartActivity view){

    this.view=view;
    playerModel= new Player();

}


    public void savePlayer(String name){

    //validation!! in the model?


        if(name.isEmpty()){
            Log.d("VALIDATION", "WRONG");
            view.setError("Name can not be epmty!");
        }
        else if(name.trim().isEmpty()){
            view.setError("Insert some characters!");
        }
        else
        {
            playerModel.setName(name);

            // write-> JsonUtil.toJSon(playerModel);
            PlayerProvider.saveToJson(playerModel);
            // Log.d("JSON", JsonUtil.toJSon(playerModel));

            view.navigateToGame();
        }


    }

}

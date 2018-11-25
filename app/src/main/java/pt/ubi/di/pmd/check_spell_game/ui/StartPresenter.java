package pt.ubi.di.pmd.check_spell_game.ui;

import android.util.Log;

import pt.ubi.di.pmd.check_spell_game.Model.Game;

public class StartPresenter {

    StartActivity view; // not null between onResume() and onPause()
    //Player playerModel;
    Game gameModel;

    //public Player getPlayerModel() {
//        return playerModel;
//    }

    public StartPresenter(StartActivity view){

    this.view=view;
    gameModel=new Game();
    view.setNameTV(gameModel.getCurrentPlayer().getName());
        Log.d("PLAYER_PRESENTER", gameModel.getCurrentPlayer().getName());
}

public void startGame(String playerName){  //validation

    if(playerName.isEmpty()){

        view.setError("Name can not be epmty!");
    }
    else if(playerName.trim().isEmpty()){
        view.setError("Insert some characters!");
    }
    else
    {
        gameModel.savePlayer(playerName);
        view.navigateToGame();
    }

}



}

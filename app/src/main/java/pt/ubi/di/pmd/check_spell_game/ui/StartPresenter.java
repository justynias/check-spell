package pt.ubi.di.pmd.check_spell_game.ui;

import pt.ubi.di.pmd.check_spell_game.Model.Game;
import pt.ubi.di.pmd.check_spell_game.Model.GameInterface;

public class StartPresenter implements StartPresenterInterface{

    StartActivityInterface view;
    GameInterface gameModel;

    public StartPresenter(StartActivityInterface view){

    this.view=view;
    gameModel=new Game();
    view.setNameTV(gameModel.getCurrentPlayer().getName());
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

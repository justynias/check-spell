package pt.ubi.di.pmd.check_spell_game.ui;
import android.util.Log;
import pt.ubi.di.pmd.check_spell_game.DataProvider.DataProvider;
import pt.ubi.di.pmd.check_spell_game.Model.Player;

public class SingleRoundPresenter {

    SingleRoundActivity view;
    Player playerModel;


    SingleRoundPresenter(SingleRoundActivity view){
        this.view=view;
        playerModel=DataProvider.readJson(view);

        Log.d("LOGGED_PLAYER", playerModel.getName());
    }

}

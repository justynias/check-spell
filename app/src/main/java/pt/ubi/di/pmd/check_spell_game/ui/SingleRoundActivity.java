package pt.ubi.di.pmd.check_spell_game.ui;

import android.app.Activity;
import android.os.Bundle;

import pt.ubi.di.pmd.check_spell_game.R;



public class SingleRoundActivity extends Activity {

    SingleRoundPresenter presenter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_round);
        presenter=new SingleRoundPresenter(this);


        // temporary
        //String playerName= getIntent().getStringExtra("CURRENT_PLAYER");
        //


}



}

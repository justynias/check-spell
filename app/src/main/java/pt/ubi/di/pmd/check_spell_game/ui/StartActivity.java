package pt.ubi.di.pmd.check_spell_game.ui;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import pt.ubi.di.pmd.check_spell_game.R;

public class StartActivity extends Activity implements View.OnClickListener{

    StartPresenter presenter;
    EditText nameTV;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        initViews();
        presenter=new StartPresenter(this);

    }


    private void initViews() {

        findViewById(R.id.startButton).setOnClickListener(this);
        nameTV = findViewById(R.id.nameEditText);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.startButton:
                presenter.savePlayer(nameTV.getText().toString());
                //presenter.startButtonClicked();
                break;
        }

    }
    void navigateToGame() {
        Intent intent = new Intent(this, SingleRoundActivity.class);

        //initial passing the player, view should not do this
       // intent.putExtra("CURRENT_PLAYER", presenter.getPlayerModel().getName());
        startActivity(intent);
    }

    void setError(String error){
        nameTV.setError(error);
    }




}


package pt.ubi.di.pmd.check_spell_game.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import pt.ubi.di.pmd.check_spell_game.R;

public class StartActivity extends Activity implements View.OnClickListener, StartActivityInterface{

    StartPresenter presenter;
    EditText nameET;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        initViews();
        presenter=new StartPresenter(this);

    }

    public void setNameTV(String playerName){
        nameET.setText(playerName ,TextView.BufferType.EDITABLE);
    }


    private void initViews() {

        findViewById(R.id.startButton).setOnClickListener(this);
        nameET = findViewById(R.id.nameEditText);
    }
    public void navigateToGame() {

        Intent intent = new Intent(this, SingleRoundActivity.class);
        startActivity(intent);
    }

    public void setError(String error){
        nameET.setError(error);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.startButton:
                presenter.startGame(nameET.getText().toString());
                break;
        }

    }


}


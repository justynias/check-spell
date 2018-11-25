package pt.ubi.di.pmd.check_spell_game.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import pt.ubi.di.pmd.check_spell_game.R;

public class StartActivity extends Activity implements View.OnClickListener{

    StartPresenter presenter;
    EditText nameET;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        initViews();
        presenter=new StartPresenter(this);

    }

    public void setNameTV(String playerName){
        //nameTV.setHint(playerName);
        nameET.setText(playerName ,TextView.BufferType.EDITABLE);
    }


    private void initViews() {

        findViewById(R.id.startButton).setOnClickListener(this);
        nameET = findViewById(R.id.nameEditText);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.startButton:
                presenter.startGame(nameET.getText().toString());
                break;
        }

    }
    void navigateToGame() {
        Intent intent = new Intent(this, SingleRoundActivity.class);

        startActivity(intent);
    }

    void setError(String error){
        nameET.setError(error);
    }


//    protected void onResume() {
//        // TODO Auto-generated method stub
//        super.onResume();
//        nameET.setText("");
//
//    }

}


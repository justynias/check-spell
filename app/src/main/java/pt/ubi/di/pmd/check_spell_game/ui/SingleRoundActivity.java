package pt.ubi.di.pmd.check_spell_game.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import pt.ubi.di.pmd.check_spell_game.R;



public class SingleRoundActivity extends Activity implements View.OnClickListener{

    private SingleRoundPresenter presenter;
    private EditText answerET;
    private TextView word1TV;
    private TextView word2TV;
    private Button checkButton;
    private Button nextButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleround);
       initViews();


       presenter=new SingleRoundPresenter(this);



        // temporary
        //String playerName= getIntent().getStringExtra("CURRENT_PLAYER");
        //
}

    private void initViews() {

        answerET = findViewById(R.id.answerEditText);
        word1TV=findViewById(R.id.word1TextView);
        word2TV=findViewById(R.id.word2TextView);
        checkButton=findViewById(R.id.checkButton);
        nextButton=findViewById(R.id.nextButton);

        //init listeners
        nextButton.setOnClickListener(this);
        checkButton.setOnClickListener(this);


    }

    public void setWord1TextView(String text){
        this.word1TV.setText(text);
    }

    public void setWord2TextView(String text){
        this.word2TV.setText(text);
    }

    public void setNextButtonVisible(){
        nextButton.setVisibility(View.VISIBLE);
    }
    public void setCheckButtonDisable(){
        checkButton.setEnabled(false);
    }
    public void cleanAnswerET(){answerET.setText("");    }
    public void setAnswerETdisable(){answerET.setEnabled(false);}


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.checkButton:
                Log.d("WYNIK", "sprawdzam..");
                this.presenter.checkAnswer(answerET.getText().toString());
                break;
            case R.id.nextButton:
                this.presenter.loadRound();
                break;
        }

    }
}

package pt.ubi.di.pmd.check_spell_game.ui;

import android.app.Activity;
import android.os.Bundle;
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
    private Button skipButton;
    private TextView pointsTV;
    private TextView levelTV;

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
        skipButton=findViewById(R.id.skipButton);
        pointsTV=findViewById(R.id.playerPointsTextView);
        levelTV=findViewById(R.id.playerLevelTextView);



        //init listeners
        nextButton.setOnClickListener(this);
        checkButton.setOnClickListener(this);
        skipButton.setOnClickListener(this);

    }

    public void setWord1TextView(String text){
        this.word1TV.setText(text);
    }

    public void setWord2TextView(String text){
        this.word2TV.setText(text);
    }

    public void setSkipButtonVisible(){
        skipButton.setVisibility(View.VISIBLE);
    }
    public void setSkipButtonInvisible(){skipButton.setVisibility(View.INVISIBLE);}
    public void setCheckButtonEnable(boolean enable){
        checkButton.setEnabled(enable);
    }
    public void setNextButtonEnable(boolean enable){
        nextButton.setEnabled(enable);
    }
    public void cleanAnswerET(){answerET.setText("");}
    public void setAnswerETenable(boolean enable){answerET.setEnabled(enable);}

    public void setPointsTV(String points){pointsTV.setText(points);}
    public void setLevelTV(String level){levelTV.setText(level);}

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.checkButton:
                this.presenter.checkAnswer(answerET.getText().toString());
                break;
            case R.id.nextButton:
                this.presenter.loadRound();
                break;
            case R.id.skipButton:
                this.presenter.loadRound();
        }

    }
}

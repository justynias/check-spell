package pt.ubi.di.pmd.check_spell_game.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import pt.ubi.di.pmd.check_spell_game.R;



public class SingleRoundActivity extends Activity {

    private SingleRoundPresenter presenter;
    private EditText answerET;
    private TextView word1TV;
    private TextView word2TV;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_round);
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

    }

    public void setword1TextView(String text){
        this.word1TV.setText(text);
    }

    public void setword2TextView(String text){
        this.word2TV.setText(text);
    }
}

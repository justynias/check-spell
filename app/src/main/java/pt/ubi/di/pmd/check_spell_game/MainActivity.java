package pt.ubi.di.pmd.check_spell_game;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import pt.ubi.di.pmd.check_spell_game.Model.Word;

public class MainActivity extends Activity {

    ArrayList<String> dictionary;
    EditText wordText;
    TextView firstPartWord;
    TextView secondPartWord;
    //TextView descriptionTextView;
    TextView resultTextView;
    List<Word> wordList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dictionary = new ArrayList<>();
        wordList= new ArrayList<>();
        wordText = (EditText) findViewById(R.id.wordEditText);
        firstPartWord= (TextView)  findViewById(R.id.word1TextView);
        secondPartWord= (TextView)  findViewById(R.id.word2TextView);

        resultTextView= (TextView) findViewById(R.id.resultTextView);

        //descriptionTextView= (TextView) findViewById(R.id.descriptionTextView);

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.dictionary)));
            while (reader.ready()) {
               dictionary.add(reader.readLine());
            }
            Random rand = new Random();
            int i = rand.nextInt(dictionary.size());
            String randomWord=dictionary.get(i);
            Log.d("slowo", randomWord);

            //StringBuilder tempWord= new StringBuilder(randomWord);
            i=rand.nextInt(randomWord.length());
            firstPartWord.setText(randomWord.substring(0,i));
            secondPartWord.setText(randomWord.substring(i+1));



        } catch (IOException e) {
            e.printStackTrace();
        }



    }
    public void checkWord(View view) {
        if(dictionary.contains(firstPartWord.getText().toString()+ wordText.getText()+secondPartWord.getText()))resultTextView.setText("GRATULACJE!");
        else resultTextView.setText("Niestety nie..");
    }
}

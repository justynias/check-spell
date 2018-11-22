package pt.ubi.di.pmd.check_spell_game.Model;

import android.util.Log;

import java.util.Random;

import pt.ubi.di.pmd.check_spell_game.DataProvider.WordProvider;

public class SingleRound {

//    private String currentWord;
//    private int tryNumber;
//    private Context context;
//
//    public SingleRound(Context context){
//        this.context=context;
//        this.tryNumber=0;
//    }
//
//    public boolean checkWord(String answer){
//        return (answer==currentWord);
//    }

    private WordProvider wordProvider;
    private int tryNumber;
    private String currentWord;
    private String dividedWord1;
    private String dividedWord2;


    public SingleRound (WordProvider wordProvider){
        this.wordProvider=wordProvider;
        this.currentWord=wordProvider.getRandomWord();
        DivideWord();
    }

    public void DivideWord(){
        Random rand = new Random();
        int i=rand.nextInt(this.currentWord.length());
        dividedWord1=currentWord.substring(0,i);
        dividedWord2=currentWord.substring(i+1);
        Log.d("WORD", currentWord);
        Log.d("WORD1", dividedWord1);
        Log.d("WORD2", dividedWord2);


    }


}

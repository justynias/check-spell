package pt.ubi.di.pmd.check_spell_game.Model;

import android.util.Log;

import java.util.Random;

import pt.ubi.di.pmd.check_spell_game.DataProvider.WordProvider;

public class SingleRound {


    private WordProvider wordProvider;
    private int tryNumber;
    private String currentWord;
    private boolean isCompleted;
    private boolean isSkipable;
    private String correctAnswer;
    private String playerAnswer;
    private String dividedWord1;
    private String dividedWord2;

public void incrementTryNumber(){
    this.tryNumber++;
}



    public void setPlayerAnswer(String playerAnswer) {

    this.playerAnswer = playerAnswer;

    }

    public boolean isSkipable() {
        return (tryNumber>=5 || playerAnswer==correctAnswer);
    }




    public String getDividedWord1() {
        return dividedWord1;
    }

    public String getDividedWord2() {
        return dividedWord2;
    }



    public int getTryNumber() {
        return tryNumber;
    }



    public boolean isCompleted() {

    Log.d("WYNIK_COR", correctAnswer);
        Log.d("WYNIK_PLAY", playerAnswer);

        return playerAnswer.equals(correctAnswer);
    }



    public SingleRound (WordProvider wordProvider){
        this.wordProvider=wordProvider;
        this.currentWord=wordProvider.getRandomWord();
        divideWord();
    }

    public void divideWord(){
        Random rand = new Random();
        int divider=rand.nextInt(currentWord.length());
        int i =divider;
        dividedWord1=currentWord.substring(0,i);
        this.dividedWord2=currentWord.substring(i+1);
        correctAnswer=currentWord.substring(divider, divider+1);

//ZA DLUGIE SLOWA, JAKIS EXCEPION
        ///
        Log.d("WORD", currentWord);
        Log.d("WORD1", dividedWord1);
        Log.d("WORD2", dividedWord2);
        Log.d("WORD_ANS", correctAnswer);

//need to add -> checking asnwer if exist in the dictionary!
    }



}

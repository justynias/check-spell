package pt.ubi.di.pmd.check_spell_game.Model;

import java.util.Random;

import pt.ubi.di.pmd.check_spell_game.DataProvider.WordProvider;

public class SingleRound implements SingleRoundInterface{ //need to add -> checking asnwer if exist in the dictionary!



    private WordProvider wordProvider;
    private int tryNumber;
    private String currentWord;
    private String correctAnswer;
    private String playerAnswer;
    private String dividedWord1;
    private String dividedWord2;

public void incrementTryNumber(){
    this.tryNumber++;
}



    public void setPlayerAnswer(String playerAnswer) {

        this.playerAnswer=dividedWord1+playerAnswer+dividedWord2;
    }

    public boolean isSkippable() {
        return (tryNumber>=5);
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
        return wordProvider.checkWord(playerAnswer);
    }


    public SingleRound (WordProvider wordProvider){
        this.wordProvider=wordProvider;
        this.currentWord=wordProvider.getRandomWord();
        divideWord();
    }

    private void divideWord(){
        Random rand = new Random();
        int divider=rand.nextInt(currentWord.length());
        int i =divider;
        dividedWord1=currentWord.substring(0,i);
        this.dividedWord2=currentWord.substring(i+1);
        correctAnswer=currentWord.substring(divider, divider+1);

    }



}

package pt.ubi.di.pmd.check_spell_game.Model;

public class Player implements PlayerInterface{

    private String name;
    private int bestScore;

    public Player(String name){
        this.name=name;
    }
    public Player(String name, int bestScore){
        this.name=name;
        this.bestScore=bestScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBestScore() {
        return bestScore;
    }

    public void setBestScore(int bestScore) {
        this.bestScore = bestScore;
    }

}

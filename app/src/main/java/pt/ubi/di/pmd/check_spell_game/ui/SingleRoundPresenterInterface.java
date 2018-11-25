package pt.ubi.di.pmd.check_spell_game.ui;

public interface SingleRoundPresenterInterface {

    void resetView();
    void loadRound();
    void updateScore();
    void checkAnswer(String playerAnswer);
    void shareHighScore();
}

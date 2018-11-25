package pt.ubi.di.pmd.check_spell_game.ui;

public interface SingleRoundActivityInterface {

    void updateWord(String dividedWord1, String dividedWord2);
    void updateScore(String points, String level);
    void setSkipButtonVisible();
    void setSkipButtonInvisible();
    void setCheckButtonEnable(boolean enable);
    void setNextButtonEnable(boolean enable);
    void cleanAnswerET();
    void setAnswerETenable(boolean enable);
    void shareHighScore(int score);
    void showHighScore();

}

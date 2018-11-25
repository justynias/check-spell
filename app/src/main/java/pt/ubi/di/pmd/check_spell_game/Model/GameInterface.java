package pt.ubi.di.pmd.check_spell_game.Model;

public interface GameInterface {

    void loadRound();
    void checkRound(String answer);
    void savePlayer(String playerName);
    Player getCurrentPlayer();
    boolean isRecordBroken();
    SingleRound getCurrentRound();
    int getPoints();
    int getLevel();

}

package pt.ubi.di.pmd.check_spell_game.Model;

public interface SingleRoundInterface {

     void setPlayerAnswer(String playerAnswer);
     boolean isSkippable();
     String getDividedWord1();
     String getDividedWord2();
     int getTryNumber();
     boolean isCompleted();
     void incrementTryNumber();
}

package pt.ubi.di.pmd.check_spell_game.DataProvider;

public interface WordProviderInterface {

    String getRandomWord();
    boolean checkWord(String word);
}

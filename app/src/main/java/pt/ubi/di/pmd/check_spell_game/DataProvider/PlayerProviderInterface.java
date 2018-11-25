package pt.ubi.di.pmd.check_spell_game.DataProvider;

import pt.ubi.di.pmd.check_spell_game.Model.Player;

public interface PlayerProviderInterface {

    Player readJson();
    boolean saveToJson(Player player);
}

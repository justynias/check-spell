package pt.ubi.di.pmd.check_spell_game.DataProvider;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

import pt.ubi.di.pmd.check_spell_game.App;
import pt.ubi.di.pmd.check_spell_game.R;

public class WordProvider {

    private final int filename= R.raw.dictionary;
    private ArrayList<String> dictionary;


    public WordProvider(){
        loadDictionary();
    }

    public String getRandomWord(){

            Random rand = new Random();
            int i = rand.nextInt(dictionary.size());
            return dictionary.get(i);
    }

    private void loadDictionary(){

        Context context= App.getContext();
        dictionary= new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(context.getResources().openRawResource(filename)));
            while (reader.ready()) {
                dictionary.add(reader.readLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}

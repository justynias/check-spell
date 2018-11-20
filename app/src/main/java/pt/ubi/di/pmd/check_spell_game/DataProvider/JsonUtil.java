package pt.ubi.di.pmd.check_spell_game.DataProvider;

import android.util.JsonWriter;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import pt.ubi.di.pmd.check_spell_game.Model.Player;

public class JsonUtil {

    public static String toJSon(Player player){
        try{
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("name", player.getName()); // Set the first name/pair
            jsonObj.put("best_score", player.getBestScore());
            return jsonObj.toString();
        }
        catch(JSONException ex) {
            ex.printStackTrace();
        }
        return null;
    }



}

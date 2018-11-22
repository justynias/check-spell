package pt.ubi.di.pmd.check_spell_game.DataProvider;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import pt.ubi.di.pmd.check_spell_game.App;
import pt.ubi.di.pmd.check_spell_game.Model.Player;

public class PlayerProvider{

    private static String filePath;
    private static final String filename= "check_spell.json";

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
   public static boolean saveToJson(Player player){
        Context context=App.getContext();
       String jsonString=toJSon(player);
       String fileContents = jsonString;
       FileOutputStream outputStream;

       try {
           outputStream = context.openFileOutput(filename, context.MODE_PRIVATE);
           outputStream.write(fileContents.getBytes());
           outputStream.close();
           filePath=context.getFilesDir().getAbsolutePath();
           return true;
       } catch (Exception e) {
           e.printStackTrace();
       }

       return false;
   }

   public static Player readJson(){

        Context context=App.getContext();
        FileInputStream inputStream;
        String json = null;

        try{
            inputStream = context.openFileInput(filename);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
            return fromJson(json);
            } catch(Exception e) {
            e.printStackTrace();
            }
        return null;

   }

   public static Player fromJson(String jsonString)
   {
       try{
           JSONObject reader = new JSONObject(jsonString);
           Player tempPlayer= new Player();
           tempPlayer.setName(reader.getString("name"));
           tempPlayer.setBestScore(reader.getInt("best_score"));
           return tempPlayer;
       }catch(JSONException e){
           e.printStackTrace();
           return null;
       }
   }

}

package pt.ubi.di.pmd.check_spell_game;

import android.app.Application;
import android.content.Context;

public class App extends Application {

    private static Context context;

    public static Context getContext() {
        //Log.d("DUPA", context.toString());
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

    }
}
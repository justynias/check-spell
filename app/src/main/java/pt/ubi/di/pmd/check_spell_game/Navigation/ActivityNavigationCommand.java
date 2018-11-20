package pt.ubi.di.pmd.check_spell_game.Navigation;

import android.app.Activity;


public class ActivityNavigationCommand implements NavigationCommand {


    private final Activity currentActivity;

    public ActivityNavigationCommand(Activity activity) {
        currentActivity = activity;
    }

    @Override
    public void navigate() {

        //currentActivity.startActivity();

    }
}

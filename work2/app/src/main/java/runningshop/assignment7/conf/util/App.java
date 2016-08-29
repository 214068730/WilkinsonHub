package runningshop.assignment7.conf.util;

import android.app.Application;
import android.content.Context;

/**
 * Created by Siraaj on 04/20/2016.
 */
public class App extends Application {
    private static Context context;
    private static App singleton;

    public void onCreate(){
        super.onCreate();
        App.context = getApplicationContext();
        singleton = this;
    }

    public static Context getAppContext(){
        return App.context;
    }
}

package leduyhung.me.m4l;

import android.app.Application;
import android.os.Build;
import android.support.v7.app.AppCompatDelegate;

import com.facebook.FacebookSdk;
import com.leduyhung.loglibrary.Logg;

public class MusicApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT_WATCH)
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        Logg.init(getString(R.string.app_name), false);
        FacebookSdk.sdkInitialize(getApplicationContext());
    }
}

package leduyhung.me.m4l.ui.main;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import leduyhung.me.m4l.R;
import leduyhung.me.m4l.ui.home.HomeFragment;

public class MainActivity extends AppCompatActivity {

    private HomeFragment homeFragment;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_main);
        downloadZipFile();
        configFragment();
    }

    private void configFragment() {

        if (getSupportFragmentManager().findFragmentById(R.id.frame_home) == null) {
            homeFragment = new HomeFragment();
            transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.frame_home, homeFragment).commit();
        }
    }

    private void downloadZipFile() {
        // TODO: download file config
    }
}
package leduyhung.me.m4l.ui.home.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import leduyhung.me.m4l.R;
import leduyhung.me.m4l.ui.playlist.ListPlayListFragment;
import leduyhung.me.m4l.ui.song.ListSongFragment;

public class HomePagerAdapter extends FragmentPagerAdapter {

    private String[] data;

    public HomePagerAdapter(FragmentManager fm, Context ctx) {
        super(fm);
        data = ctx.getResources().getStringArray(R.array.home_tab);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                return new ListSongFragment();
        }
        return new ListPlayListFragment();
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return data[position];
    }
}
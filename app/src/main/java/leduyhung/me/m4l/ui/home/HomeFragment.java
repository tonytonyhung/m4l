package leduyhung.me.m4l.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import leduyhung.me.m4l.R;
import leduyhung.me.m4l.ui.home.adapter.HomePagerAdapter;

public class HomeFragment extends Fragment{

    private Context mContext;

    private View v;
    private ViewPager vPager;
    private TabLayout tabLayout;
    private HomePagerAdapter adap;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        this.mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_home, container, false);
        vPager = v.findViewById(R.id.v_pager);
        tabLayout = v.findViewById(R.id.sliding_tabs);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        configView();
    }

    private void configView() {

        adap = new HomePagerAdapter(getChildFragmentManager(), mContext);
        vPager.setAdapter(adap);
        vPager.setOffscreenPageLimit(5);
        tabLayout.setupWithViewPager(vPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
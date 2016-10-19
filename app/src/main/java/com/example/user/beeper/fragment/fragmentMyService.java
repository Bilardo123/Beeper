package com.example.user.beeper.fragment;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.beeper.R;
import com.example.user.beeper.adapter.TabsMyServiceAdapter;
import com.example.user.beeper.utils.Constanta;
import com.example.user.beeper.utils.FontChangeCrawler;
import com.example.user.beeper.utils.FragmentTransfer;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by user on 9/13/2016.
 */
public class fragmentMyService extends Fragment{

    @Bind(R.id.tabMyService) TabLayout tabLayout;
    @Bind(R.id.viewpagerMyService) ViewPager viewPager;
    @Bind(R.id.layoutContent1MyService) CardView cardView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View view = inflater.inflate(R.layout.fragment_myservice, container, false);
        ButterKnife.bind(this, view);

        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.info));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.additional));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.review));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.portofolio));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.faq));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        TabsMyServiceAdapter adapter = new TabsMyServiceAdapter
                (getFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(final TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return view;
    }

    @OnClick(R.id.fabMyService)
    public void onClick()
    {
        Bundle bundle = new Bundle();
        bundle.putString("schedule", "detailschedule");
        fragmentScheduleHome fragSchedule = new fragmentScheduleHome();
        fragSchedule.setArguments(bundle);
        FragmentTransfer.callFragment(getActivity(), fragSchedule, R.id.layoutHome, "SCHEDULE");
    }
}
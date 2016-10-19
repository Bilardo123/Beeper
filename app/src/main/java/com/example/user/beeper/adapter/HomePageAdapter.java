package com.example.user.beeper.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.user.beeper.fragment.fragmentHome;
import com.example.user.beeper.fragment.fragmentHomeSplash;

/**
 * Created by user on 10/5/2016.
 */
public class HomePageAdapter extends FragmentStatePagerAdapter {

    public HomePageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                return new fragmentHomeSplash();
            case 1:
                return new fragmentHome();
        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 2;
    }

}

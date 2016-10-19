package com.example.user.beeper.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.user.beeper.fragment.fragmentClosed;
import com.example.user.beeper.fragment.fragmentConfirmed;
import com.example.user.beeper.fragment.fragmentWaiting;

/**
 * Created by user on 8/18/2016.
 */
public class OrderListTabAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;

    public OrderListTabAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                return new fragmentWaiting();
            case 1:
                return new fragmentConfirmed();
            case 2:
                return new fragmentClosed();
        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return mNumOfTabs;
    }

}
package com.example.user.beeper.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.user.beeper.fragment.fragmentAdditionalMyService;
import com.example.user.beeper.fragment.fragmentFAQMyService;
import com.example.user.beeper.fragment.fragmentInfoMyService;
import com.example.user.beeper.fragment.fragmentPortofolioMyService;
import com.example.user.beeper.fragment.fragmentReviewMyService;

/**
 * Created by user on 8/15/2016.
 */
public class TabsMyServiceAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;

    public TabsMyServiceAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                return new fragmentInfoMyService();
            case 1:
                return new fragmentAdditionalMyService();
            case 2:
                return new fragmentReviewMyService();
            case 3:
                return new fragmentPortofolioMyService();
            case 4:
                return new fragmentFAQMyService();
        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return mNumOfTabs;
    }

}

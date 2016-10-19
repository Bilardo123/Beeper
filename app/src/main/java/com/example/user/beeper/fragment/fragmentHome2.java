package com.example.user.beeper.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.beeper.R;
import com.example.user.beeper.adapter.HomePageAdapter;
import com.example.user.beeper.utils.Constanta;
import com.example.user.beeper.utils.FontChangeCrawler;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by user on 10/4/2016.
 */
public class fragmentHome2 extends Fragment {

    @Bind(R.id.verticalViewPagerHome) com.example.user.beeper.component.VerticalViewPager verticalViewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance)
    {
        View view = inflater.inflate(R.layout.fragment_home_wrap, container, false);
        ButterKnife.bind(this, view);

        setComponentView();

        return view;
    }

    public void setComponentView()
    {
        HomePageAdapter adapter = new HomePageAdapter(getActivity().getSupportFragmentManager());
        verticalViewPager.setAdapter(adapter);
    }
}

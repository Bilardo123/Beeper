package com.example.user.beeper.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.beeper.R;
import com.example.user.beeper.utils.Constanta;
import com.example.user.beeper.utils.FontChangeCrawler;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by user on 8/29/2016.
 */
public class fragmentUndangTeman extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance)
    {
        View view = inflater.inflate(R.layout.fragment_undang_teman, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

}
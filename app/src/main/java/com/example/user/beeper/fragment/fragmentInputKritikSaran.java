package com.example.user.beeper.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.user.beeper.R;
import com.example.user.beeper.utils.Constanta;
import com.example.user.beeper.utils.FontChangeCrawler;
import com.example.user.beeper.utils.GlobalUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by user on 8/18/2016.
 */
public class fragmentInputKritikSaran extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance)
    {
        View view = inflater.inflate(R.layout.fragment_input_kritik_saran, container, false);
        ButterKnife.bind(this, view);
        GlobalUtils.setupUI(view, getActivity());
        return view;
    }

    @OnClick(R.id.btnHubungiSidebeepPengaturanInputKritikSaran)
    public void onClick()
    {
        getActivity().finish();
    }

}

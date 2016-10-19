package com.example.user.beeper.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.beeper.R;
import com.example.user.beeper.utils.Constanta;
import com.example.user.beeper.utils.FontChangeCrawler;
import com.example.user.beeper.utils.FragmentTransfer;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by user on 8/18/2016.
 */
public class fragmentKritikSaran3 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance)
    {
        View view = inflater.inflate(R.layout.fragment_kritik_dan_saran4, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.btnHubungiSidebeepPengaturan4)
    public void onClick()
    {
        FragmentTransfer.callFragment(getActivity(), new fragmentInputKritikSaran(), R.id.layoutSide, "INPUTKRITIKSARAN");
    }

}

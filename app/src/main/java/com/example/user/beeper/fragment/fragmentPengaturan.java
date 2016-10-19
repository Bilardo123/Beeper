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
 * Created by user on 8/30/2016.
 */
public class fragmentPengaturan extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance)
    {
        View view = inflater.inflate(R.layout.fragment_pengaturan, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.txtPengaturanNotifikasi, R.id.txtPengaturanCreditCard})
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.txtPengaturanNotifikasi : {
                break;
            }
            case R.id.txtPengaturanCreditCard : {
                FragmentTransfer.callFragment(getActivity(), new fragmentAddKartuKreditPengaturan(), R.id.layoutSide, "TAMBAHKARTUKREDITPENGATURAN");
                break;
            }
        }
    }

}
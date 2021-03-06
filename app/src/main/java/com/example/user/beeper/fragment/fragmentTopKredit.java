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
import com.example.user.beeper.utils.GlobalUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by user on 8/30/2016.
 */
public class fragmentTopKredit extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance)
    {
        View view = inflater.inflate(R.layout.fragment_top_kredit, container, false);
        ButterKnife.bind(this, view);
        GlobalUtils.setupUI(view, getActivity());
        return view;
    }

    @OnClick(R.id.btnTopUpPengaturanKreditSidebeep)
    public void onClick()
    {
        FragmentTransfer.callFragment(getActivity(), new fragmentAddTopUpPengaturan(), R.id.layoutSide, "TAMBAHTOPUPPENGATURAN");
    }

}

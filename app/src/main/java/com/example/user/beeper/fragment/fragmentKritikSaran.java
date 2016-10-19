package com.example.user.beeper.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.example.user.beeper.R;
import com.example.user.beeper.utils.Constanta;
import com.example.user.beeper.utils.FontChangeCrawler;
import com.example.user.beeper.utils.FragmentTransfer;

import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import butterknife.OnItemClick;

/**
 * Created by user on 8/10/2016.
 */
public class fragmentKritikSaran extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance)
    {
        View view = inflater.inflate(R.layout.fragment_kritik_dan_saran, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.rdoSangatMembantu, R.id.rdoMembingungkan, R.id.rdoTidakSuka})
    public void onRadioClick(RadioButton radioButton)
    {
        switch (radioButton.getId()){
            case R.id.rdoSangatMembantu : {
                FragmentTransfer.callFragment(getActivity(), new fragmentKritikSaran1(), R.id.layoutSide, "KRITIKSARAN1");
                break;}
            case R.id.rdoMembingungkan : {
                FragmentTransfer.callFragment(getActivity(), new fragmentKritikSaran2(), R.id.layoutSide, "KRITIKSARAN2");
                break;}
            case R.id.rdoTidakSuka : {
                FragmentTransfer.callFragment(getActivity(), new fragmentKritikSaran3(), R.id.layoutSide, "KRITIKSARAN3");
                break;}
        }

    }
}

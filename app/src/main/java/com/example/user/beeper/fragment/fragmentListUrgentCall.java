package com.example.user.beeper.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.user.beeper.R;
import com.example.user.beeper.adapter.ListViewFavoritAdapter;
import com.example.user.beeper.adapter.ListViewUrgentCallAdapter;
import com.example.user.beeper.utils.Constanta;
import com.example.user.beeper.utils.FontChangeCrawler;
import com.example.user.beeper.utils.FragmentTransfer;
import com.example.user.beeper.utils.GlobalUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by user on 9/5/2016.
 */
public class fragmentListUrgentCall extends Fragment {

    @Bind(R.id.listViewUrgentCall) ListView lstUrgentCall;

    ListViewUrgentCallAdapter adapter;
    List<String> lstData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance)
    {
        View view = inflater.inflate(R.layout.fragment_listview_urgent_call, container, false);
        ButterKnife.bind(this, view);

        setComponentView();
        return view;
    }

    public void setComponentView()
    {
        lstData = new ArrayList<String>();
        lstData.add("test");
        lstData.add("test");
        lstData.add("test");
        lstData.add("test");
        adapter = new ListViewUrgentCallAdapter(getContext(), lstData);
        lstUrgentCall.setAdapter(adapter);
        GlobalUtils.setListViewHeightBasedOnChildren(lstUrgentCall);
    }

    @OnClick(R.id.fabListViewUrgentCall)
    public void onClick()
    {
        FragmentTransfer.callFragment(getActivity(), new fragmentCheckoutProfile(), R.id.layoutHome, "CHECKOUTPROFILE");
    }

}

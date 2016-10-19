package com.example.user.beeper.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.user.beeper.R;
import com.example.user.beeper.adapter.ListViewInboxAdapter;
import com.example.user.beeper.utils.Constanta;
import com.example.user.beeper.utils.FontChangeCrawler;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by user on 8/31/2016.
 */
public class fragmentInboxPengaturan extends Fragment {

    @Bind(R.id.listInboxPengaturan) ListView listInbox;
    ListViewInboxAdapter adapterList;
    List<String> lstData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance)
    {
        View view = inflater.inflate(R.layout.fragment_inbox_pengaturan, container, false);
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
        lstData.add("test");
        lstData.add("test");
        adapterList = new ListViewInboxAdapter(getActivity(), lstData);
        listInbox.setAdapter(adapterList);
    }

}


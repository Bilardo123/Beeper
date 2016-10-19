package com.example.user.beeper.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.user.beeper.R;
import com.example.user.beeper.adapter.ListViewFavoritAdapter;
import com.example.user.beeper.utils.Constanta;
import com.example.user.beeper.utils.FontChangeCrawler;
import com.example.user.beeper.utils.FragmentTransfer;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

/**
 * Created by user on 8/30/2016.
 */
public class fragmentFavoritHome extends Fragment {

    @Bind(R.id.listFavoritHome) ListView lstFavoritHome;

    ListViewFavoritAdapter adapter;
    List<String> lstData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance)
    {
        View view = inflater.inflate(R.layout.fragment_favorit_home, container, false);
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
        adapter = new ListViewFavoritAdapter(getContext(), lstData);
        lstFavoritHome.setAdapter(adapter);
    }

    @OnItemClick(R.id.listFavoritHome)
    public void onClick()
    {
        FragmentTransfer.callFragment(getActivity(), new fragmentMyService(), R.id.layoutHome, "MYSERVICE");
    }

}
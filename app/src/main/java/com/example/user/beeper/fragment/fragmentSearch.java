package com.example.user.beeper.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.user.beeper.R;
import com.example.user.beeper.adapter.SearchListAdapter;
import com.example.user.beeper.utils.Constanta;
import com.example.user.beeper.utils.FontChangeCrawler;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by user on 9/26/2016.
 */
public class fragmentSearch extends Fragment {

    @Bind(R.id.listSearchFavoritHome) ListView listView;
    List<String> lstData;
    SearchListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View view = inflater.inflate(R.layout.fragment_search_favorit_home, container, false);
        ButterKnife.bind(this, view);
        setComponentView();
        return view;
    }

    public void setComponentView()
    {
        lstData = new ArrayList<>();
        lstData.add("Test");
        lstData.add("Test");
        lstData.add("Test");
        lstData.add("Test");
        lstData.add("Test");
        adapter = new SearchListAdapter(getActivity(), lstData);
        listView.setAdapter(adapter);
    }
}
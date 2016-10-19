package com.example.user.beeper.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.user.beeper.R;
import com.example.user.beeper.adapter.HorizontalListviewHomeAdapter;
import com.example.user.beeper.utils.Constanta;
import com.example.user.beeper.utils.FontChangeCrawler;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by user on 7/19/2016.
 */
public class fragmentHome extends Fragment {

    @Bind(R.id.horizontal_recycler_view) RecyclerView recyclerView;
    @Bind(R.id.horizontalRecyclerViewServisPopuler) RecyclerView recyclerViewPromoteServis;
    List<String> lstHorizontal;
    HorizontalListviewHomeAdapter horizontalAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance)
    {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);

        setComponentView();

        return view;
    }

    public void setComponentView()
    {
        lstHorizontal = new ArrayList<String>();
        lstHorizontal.add("test1");
        lstHorizontal.add("test1");
        lstHorizontal.add("test1");
        lstHorizontal.add("test1");
        lstHorizontal.add("test1");
        horizontalAdapter = new HorizontalListviewHomeAdapter(lstHorizontal);
        LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManagaer);
        recyclerView.setAdapter(horizontalAdapter);

        LinearLayoutManager horizontalLayoutManagaer2 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPromoteServis.setLayoutManager(horizontalLayoutManagaer2);
        recyclerViewPromoteServis.setAdapter(horizontalAdapter);
    }

}

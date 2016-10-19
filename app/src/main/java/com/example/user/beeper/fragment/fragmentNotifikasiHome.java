package com.example.user.beeper.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.user.beeper.R;
import com.example.user.beeper.adapter.ExpandableNotifikasiHomeAdapter;
import com.example.user.beeper.utils.Constanta;
import com.example.user.beeper.utils.FontChangeCrawler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by user on 8/20/2016.
 */
public class fragmentNotifikasiHome extends Fragment {

    @Bind(R.id.expandableListNotifikasiHome) ExpandableListView expListView;
    ExpandableNotifikasiHomeAdapter listAdapter;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View view = inflater.inflate(R.layout.fragment_notifikasi_home, container, false);
        ButterKnife.bind(this, view);

        prepareListData();
        listAdapter = new ExpandableNotifikasiHomeAdapter(getContext(), listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);

        return view;
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("23 December 2016");
        listDataHeader.add("24 December 2016");
        listDataHeader.add("25 December 2016");

        // Adding child data
        List<String> top250 = new ArrayList<String>();
        top250.add("The Shawshank Redemption");
        top250.add("The Godfather White");
        top250.add("The Godfather: Part II");
        top250.add("Pulp Fiction White");
        top250.add("The Good, the Bad and the Ugly");
        top250.add("The Dark Knight");
        top250.add("12 Angry Men");

        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("The Conjuring");
        nowShowing.add("Despicable Me 2");
        nowShowing.add("Turbo");
        nowShowing.add("Grown Ups 2");
        nowShowing.add("Red 2");
        nowShowing.add("The Wolverine");

        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("2 Guns");
        comingSoon.add("The Smurfs 2");
        comingSoon.add("The Spectacular Now");
        comingSoon.add("The Canyons");
        comingSoon.add("Europa Report");

        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), comingSoon);
    }
}

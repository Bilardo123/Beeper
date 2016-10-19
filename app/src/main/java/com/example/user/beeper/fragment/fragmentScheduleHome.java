package com.example.user.beeper.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.user.beeper.R;
import com.example.user.beeper.adapter.ExpandableScheduleHomeAdapter;
import com.example.user.beeper.adapter.ScheduleListAdapter;
import com.example.user.beeper.utils.Constanta;
import com.example.user.beeper.utils.FontChangeCrawler;
import com.example.user.beeper.utils.GlobalUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by user on 8/22/2016.
 */
public class fragmentScheduleHome extends Fragment {

    @Bind(R.id.expandableListScheduleHome) ExpandableListView expListView;
    @Bind(R.id.listViewScheduleHome) ListView listView;
    @Bind(R.id.layoutDetailScheduleSider) LinearLayout layoutDetailSchedule;
    ExpandableScheduleHomeAdapter expAdapter;
    ScheduleListAdapter listAdapter;
    List<String> listDataHeader;
    List<String> listDataSchedule;
    HashMap<String, List<String>> listDataChild;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {

        String str = getArguments().getString("schedule");
        View view = inflater.inflate(R.layout.fragment_schedule_home, container, false);
        ButterKnife.bind(this, view);

        prepareListData();
        expAdapter = new ExpandableScheduleHomeAdapter(getContext(), listDataHeader, listDataChild);
        expListView.setAdapter(expAdapter);
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                GlobalUtils.setExpandableListViewHeight(parent, groupPosition);
                return false;
            }
        });

        listAdapter = new ScheduleListAdapter(getContext(), listDataSchedule);
        listView.setAdapter(listAdapter);
        GlobalUtils.setListViewHeightBasedOnChildren(listView);

        if(str.equals("detailschedule"))
            layoutDetailSchedule.setVisibility(View.VISIBLE);
        else
            layoutDetailSchedule.setVisibility(View.GONE);

        return view;
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataSchedule = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("23 December 2016");
        listDataSchedule.add("hitam");
        listDataSchedule.add("hitam");
        listDataSchedule.add("hitam");

        // Adding child data
        List<String> top250 = new ArrayList<String>();
        top250.add("The Shawshank Redemption");

        listDataChild.put(listDataHeader.get(0), top250);
    }
}
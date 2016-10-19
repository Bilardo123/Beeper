package com.example.user.beeper.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.user.beeper.R;
import com.example.user.beeper.adapter.OrderListAdapter;
import com.example.user.beeper.utils.Constanta;
import com.example.user.beeper.utils.FontChangeCrawler;

import java.util.List;
import java.util.Vector;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by user on 8/18/2016.
 */
public class fragmentConfirmed extends Fragment {

    @Bind(R.id.listOrderHome) ListView listView;
    OrderListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View view = inflater.inflate(R.layout.fragment_listorder_order_home, container, false);
        ButterKnife.bind(this, view);
        setComponentView();
        return view;
    }

    public void setComponentView()
    {
        List<String> listdata = new Vector<>();
        listdata.add("Hallo");
        listdata.add("Test");
        listdata.add("Test2");
        adapter = new OrderListAdapter(getContext(), listdata, "Confirmed");
        listView.setAdapter(adapter);
    }
}
package com.example.user.beeper.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.user.beeper.R;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by user on 9/5/2016.
 */
public class ListViewUrgentCallAdapter extends BaseAdapter {

    List<String> listUrgentCall;
    Context ctx;

    public ListViewUrgentCallAdapter(Context ctx, List<String> list)
    {
        this.ctx = ctx;
        listUrgentCall = list;
    }

    @Override
    public int getCount() {
        return listUrgentCall.size();
    }

    @Override
    public Object getItem(int position) {
        return listUrgentCall.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if(view == null)
        {
            view = ((LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.fragment_listrow_urgent_call, null);
        }
        ButterKnife.bind(this, view);
        return view;
    }
}

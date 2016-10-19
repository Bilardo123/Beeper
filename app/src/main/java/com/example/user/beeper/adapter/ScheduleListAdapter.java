package com.example.user.beeper.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

import com.example.user.beeper.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by user on 8/22/2016.
 */
public class ScheduleListAdapter extends BaseAdapter {

    @Bind(R.id.layoutBottomListScheduleHome) LinearLayout layoutBottom;
    List<String> listSchedule;
    Context ctx;

    public ScheduleListAdapter(Context ctx, List<String> list)
    {
        this.ctx = ctx;
        listSchedule = list;
    }

    @Override
    public int getCount() {
        return listSchedule.size();
    }

    @Override
    public Object getItem(int position) {
        return listSchedule.get(position);
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
            view = ((LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.fragment_listview_schedule_home, null);
        }
        ButterKnife.bind(this, view);

        String status = (String) getItem(position);
        layoutBottom.setBackgroundColor(ctx.getResources().getColor(R.color.colorPrimaryBlack));
        return view;
    }
}

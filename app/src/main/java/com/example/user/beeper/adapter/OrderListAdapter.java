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
 * Created by user on 8/18/2016.
 */
public class OrderListAdapter extends BaseAdapter {

    List<String> listOrder;
    String option;
    Context ctx;

    @Bind(R.id.layoutBottomListviewOrderHome) LinearLayout layoutBottom;

    public OrderListAdapter(Context ctx, List<String> list, String option)
    {
        this.ctx = ctx;
        listOrder = list;
        this.option = option;
    }

    @Override
    public int getCount() {
        return listOrder.size();
    }

    @Override
    public Object getItem(int position) {
        return listOrder.get(position);
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
            if(option.equals("Closed"))
                view = ((LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.fragment_listvieworder_order_home2, null);
            else
                view = ((LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.fragment_listvieworder_order_home, null);
        }
        ButterKnife.bind(this, view);

        String status = listOrder.get(position);

        if(option.equals("Waiting"))
        {
            layoutBottom.setBackgroundColor(ctx.getResources().getColor(R.color.tab_waiting));
        }
        else if(option.equals("Confirmed"))
        {
            layoutBottom.setBackgroundColor(ctx.getResources().getColor(R.color.tab_confirmed));
        }
        else if(option.equals("Closed"))
        {
            if(status.equals("Finish"))
                layoutBottom.setBackgroundColor(ctx.getResources().getColor(R.color.tab_closed_finish));
            else
                layoutBottom.setBackgroundColor(ctx.getResources().getColor(R.color.tab_closed_cancel));
        }

        return view;
    }
}

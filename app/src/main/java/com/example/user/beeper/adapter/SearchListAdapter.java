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
 * Created by user on 9/27/2016.
 */
public class SearchListAdapter extends BaseAdapter {

    List<String> listSearch;
    Context ctx;

    public SearchListAdapter(Context ctx, List<String> list)
    {
        this.ctx = ctx;
        listSearch = list;
    }

    @Override
    public int getCount() {
        return listSearch.size();
    }

    @Override
    public Object getItem(int position) {
        return listSearch.get(position);
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
            view = ((LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.fragment_list_favorit_home, null);
        }
        ButterKnife.bind(this, view);

        return view;
    }
}

package com.example.user.beeper.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.user.beeper.R;
import com.example.user.beeper.fragment.fragmentDetailInboxPengaturan;
import com.example.user.beeper.utils.FragmentTransfer;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by user on 8/31/2016.
 */
public class ListViewInboxAdapter extends BaseAdapter {

    List<String> listSchedule;
    FragmentActivity act;

    public ListViewInboxAdapter(FragmentActivity act, List<String> list)
    {
        this.act = act;
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
            view = ((LayoutInflater)act.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.fragment_listrow_inbox_pengaturan, null);
        }
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.layoutListRowInboxHome)
    public void onClick()
    {
        FragmentTransfer.callFragment(act, new fragmentDetailInboxPengaturan(), R.id.layoutSide, "DETAILPENGATURAN");
    }
}
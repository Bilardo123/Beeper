package com.example.user.beeper.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.user.beeper.R;
import com.example.user.beeper.adapter.ExpandableDetailServicePayment;
import com.example.user.beeper.adapter.SlidingImageDetailServiceAdapter;
import com.example.user.beeper.adapter.TimeLineDetailServicePaymentStrukAdapter;
import com.example.user.beeper.utils.Constanta;
import com.example.user.beeper.utils.FontChangeCrawler;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by user on 8/24/2016.
 */
public class fragmentDetailServicePaymentStruk extends Fragment {

    @Bind(R.id.pagerDetailServiceCheckoutProfileStruk)
    ViewPager pager;
    @Bind(R.id.indicatorDetailServiceCheckoutProfileStruk)
    CirclePageIndicator indicator;
    @Bind(R.id.expandableCheckoutProfileStruk) ExpandableListView expandableListView;
    @Bind(R.id.recyclerViewCheckoutProfileStruk)
    RecyclerView recyclerView;

    private static final Integer[] IMAGES= {R.drawable.pianist,R.drawable.chelsea_islan,R.drawable.home_unsplash,R.drawable.sider_home_promo};
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();
    ExpandableDetailServicePayment adapter;
    TimeLineDetailServicePaymentStrukAdapter timeLineAdapter;
    private List<String> listTimeline;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View view = inflater.inflate(R.layout.fragment_checkout_profile_struk, container, false);
        ButterKnife.bind(this, view);

        setComponentView();
        setInitFile();

        return view;
    }

    public void setComponentView()
    {
        for(int i=0;i<IMAGES.length;i++)
            ImagesArray.add(IMAGES[i]);
        pager.setAdapter(new SlidingImageDetailServiceAdapter(getActivity(),ImagesArray));
        indicator.setViewPager(pager);
        final float density = getResources().getDisplayMetrics().density;

        ArrayList<String> listDataHeader = new ArrayList<String>();
        HashMap<String, List<String>> listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("test alamat");

        // Adding child data
        List<String> alasan = new ArrayList<String>();
        alasan.add("test comment");

        listDataChild.put(listDataHeader.get(0), alasan);
        adapter = new ExpandableDetailServicePayment(getActivity(), listDataHeader, listDataChild);
        expandableListView.setAdapter(adapter);

        //Set circle indicator radius
        indicator.setRadius(5 * density);

        NUM_PAGES = IMAGES.length;

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                pager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);

        // Pager listener over indicator
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });

    }

    public void setInitFile()
    {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        listTimeline = new ArrayList<String>();
        for(int i = 0;i <7;i++) {
            listTimeline.add("test");
        }

        timeLineAdapter = new TimeLineDetailServicePaymentStrukAdapter(listTimeline);
        recyclerView.setAdapter(timeLineAdapter);
    }
}
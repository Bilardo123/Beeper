package com.example.user.beeper.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.beeper.R;
import com.example.user.beeper.adapter.TimeLineDetailServicePaymentStrukAdapter.TimeLineViewHolder;
import com.vipul.hp_hp.timelineview.TimelineView;

import java.util.List;

/**
 * Created by user on 8/25/2016.
 */
public class TimeLineDetailServicePaymentStrukAdapter extends RecyclerView.Adapter<TimeLineViewHolder> {

    private List<String> mFeedList;
    private Context mContext;

    public TimeLineDetailServicePaymentStrukAdapter(List<String> feedList) {
        mFeedList = feedList;
    }

    @Override
    public int getItemViewType(int position) {
        return TimelineView.getTimeLineViewType(position,getItemCount());
    }

    @Override
    public TimeLineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        mContext = parent.getContext();
        View view = View.inflate(parent.getContext(), R.layout.fragment_timeline_detail_service_profile_struk, null);


        return new TimeLineViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(TimeLineViewHolder holder, int position) {

        //holder.detail.setText(mFeedList.get(position));

    }

    @Override
    public int getItemCount() {
        return (mFeedList!=null? mFeedList.size():0);
    }

    public class TimeLineViewHolder extends RecyclerView.ViewHolder {
        public TextView detail;
        public ImageView imgProfile;
        public TimelineView mTimelineView;

        public TimeLineViewHolder(View itemView, int viewType) {
            super(itemView);
            detail = (TextView) itemView.findViewById(R.id.txtDetailTimelineDetailServiceProfileStruk);
            imgProfile = (ImageView) itemView.findViewById(R.id.imgProfileTimelineDetailServiceProfileStruk);
            mTimelineView = (TimelineView) itemView.findViewById(R.id.time_marker);
            mTimelineView.initLine(viewType);
        }
    }
}

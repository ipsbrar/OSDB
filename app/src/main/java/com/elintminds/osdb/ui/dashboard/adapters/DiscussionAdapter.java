package com.elintminds.osdb.ui.dashboard.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.dashboard.Interfaces.DiscussionOnClick;
import com.elintminds.osdb.ui.dashboard.beans.DiscussionAdapterBean;
import com.elintminds.osdb.ui.discussion_comments.view.DiscussionCommentsActivity;
import com.elintminds.osdb.ui.report.view.ReportActivity;
import com.elintminds.osdb.utils.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

public class DiscussionAdapter extends RecyclerView.Adapter<DiscussionAdapter.ViewHolder> {
    private Context context;
    private ArrayList<DiscussionAdapterBean.Threads> dataList;
    private DiscussionOnClick discussionOnClick;

    public DiscussionAdapter(Context context, ArrayList<DiscussionAdapterBean.Threads> dataList, DiscussionOnClick discussionOnClick) {
        this.context = context;
        this.dataList = dataList;
        this.discussionOnClick = discussionOnClick;
        Log.e("DATA BORN", "" + dataList.size());
    }

    @NonNull
    @Override
    public DiscussionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.discussion_adapter_item, viewGroup, false);
        return new DiscussionAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiscussionAdapter.ViewHolder viewHolder, int i) {
//        Utils.justify(viewHolder.commentTxt);

        String discription = Html.fromHtml(dataList.get(i).getDescription().trim()).toString();

        viewHolder.playerName.setText(dataList.get(i).getCreated_by().getName() != null ? dataList.get(i).getCreated_by().getName() : "");
        viewHolder.commentsNumber.setText(dataList.get(i).getComments_count() != null ? dataList.get(i).getComments_count() : "");
        viewHolder.commentTxt.setText(dataList.get(i).getDescription() != null ? discription.trim() : "");
//      2019-02-21 03:24:54
//

//        Utils.getTimeAgo();
        long timeInLong = getLongTime(dataList.get(i).getUpdated_at() != null ? dataList.get(i).getUpdated_at() : "2019-02-21 03:24:54");
//        Log.e("TimeCheckLong","long   "+timeInLong);
//        String dateFor = Utils.getDate(timeInLong,"yyyy-dd-MM hh:mm:ss");
//        Log.e("TimeCheckLong","date   "+dateFor);
        viewHolder.hours_txt.setText(Utils.getTimeAgo(timeInLong));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView commentTxt, playerName, commentsNumber, hours_txt;
        RelativeLayout commentMainLay;
        LinearLayout reportLay;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            commentTxt = itemView.findViewById(R.id.comment_txt);
            commentsNumber = itemView.findViewById(R.id.comments_number);
            commentMainLay = itemView.findViewById(R.id.comment_main_lay);
            hours_txt = itemView.findViewById(R.id.hours_txt);
            reportLay = itemView.findViewById(R.id.reportLay);
            playerName = itemView.findViewById(R.id.player_name);

            commentMainLay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (dataList.get(getAdapterPosition()).getComments_count() != null && Integer.parseInt(dataList.get(getAdapterPosition()).getComments_count()) > 0)
                        discussionOnClick.discussionOnClick(getAdapterPosition(), dataList.get(getAdapterPosition()).getId());

                }
            });
            reportLay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    discussionOnClick.discussionReportOnClick(getAdapterPosition(), dataList.get(getAdapterPosition()).getId());

                }
            });
        }
    }

    public void setDataList(ArrayList<DiscussionAdapterBean.Threads> data) {
        Log.e("DATA", "" + data);
        if (data == null || data.isEmpty()) {
            return;
        }

        this.dataList = data;
        Log.e("DA LIST", "" + dataList.size());
    }

    private long getLongTime(String rawDate) {
        String string_date = rawDate;

        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            Date d = f.parse(string_date);
            long milliseconds = d.getTime();
            return milliseconds;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0L;
    }
}

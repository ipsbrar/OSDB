package com.osdb.android.ui.dashboard.adapters;

import android.content.Context;
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
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.osdb.android.R;
import com.osdb.android.ui.dashboard.Interfaces.DiscussionOnClick;
import com.osdb.android.ui.dashboard.beans.DiscussionAdapterBean;
import com.osdb.android.utils.Utils;
import de.hdodenhof.circleimageview.CircleImageView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
        DiscussionAdapterBean.Threads disscussionBean = dataList.get(i);


        if (disscussionBean.getDescription() != null) {
            String discription = Html.fromHtml(disscussionBean.getDescription().trim()).toString();
            viewHolder.commentTxt.setText(disscussionBean.getDescription() != null ? discription.trim() : "");
        }
        viewHolder.playerName.setText(disscussionBean.getCreated_by().getName() != null ? disscussionBean.getCreated_by().getName() : "");
        viewHolder.commentsNumber.setText(disscussionBean.getComments_count() != null ? disscussionBean.getComments_count() : "");

//      2019-02-21 03:24:54
        if (disscussionBean.getCreated_by() != null && disscussionBean.getCreated_by().getAssets() != null
                && disscussionBean.getCreated_by().getAssets().length > 0) {
            RequestOptions requestOptions = new RequestOptions();
            requestOptions.placeholder(R.drawable.img_player_empty);
            Glide.with(context).setDefaultRequestOptions(requestOptions).load(disscussionBean.getCreated_by().getAssets()[0].getFile_name()).into(viewHolder.user_Image);
        }

//        Utils.getTimeAgo();
        long timeInLong = getLongTime(disscussionBean.getUpdated_at() != null ? disscussionBean.getUpdated_at() : "2019-02-21 03:24:54");
//        Log.e("TimeCheckLong","long   "+timeInLong);
//        String dateFor = Utils.getDate(timeInLong,"yyyy-dd-MM hh:mm:ss");
//        Log.e("TimeCheckLong","date   "+dateFor);
        viewHolder.hours_txt.setText("- "+Utils.getTimeAgo(timeInLong));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView commentTxt, playerName, commentsNumber, hours_txt;
        RelativeLayout commentMainLay;
        LinearLayout reportLay;
        CircleImageView user_Image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            commentTxt = itemView.findViewById(R.id.comment_txt);
            commentsNumber = itemView.findViewById(R.id.comments_number);
            commentMainLay = itemView.findViewById(R.id.comment_main_lay);
            hours_txt = itemView.findViewById(R.id.hours_txt);
            reportLay = itemView.findViewById(R.id.reportLay);
            playerName = itemView.findViewById(R.id.player_name);
            user_Image = itemView.findViewById(R.id.user_Image);

            commentMainLay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DiscussionAdapterBean.Threads disscussionBeanOnCLick = dataList.get(getAdapterPosition());
                    String filePath = "";
                    if (disscussionBeanOnCLick.getCreated_by() != null && disscussionBeanOnCLick.getCreated_by().getAssets() != null
                            && disscussionBeanOnCLick.getCreated_by().getAssets().length > 0) {
                         filePath = disscussionBeanOnCLick.getCreated_by().getAssets()[0].getFile_name();
                    }
                    if (dataList.get(getAdapterPosition()).getComments_count() != null && Integer.parseInt(dataList.get(getAdapterPosition()).getComments_count()) > 0)
                    discussionOnClick.discussionOnClick(disscussionBeanOnCLick.getId(),disscussionBeanOnCLick.getCreated_by().getName()
                    ,disscussionBeanOnCLick.getDescription(),disscussionBeanOnCLick.getCreated_at()
                            ,filePath,disscussionBeanOnCLick.getComments_count());

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

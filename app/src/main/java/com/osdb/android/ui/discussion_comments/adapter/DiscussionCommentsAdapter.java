package com.osdb.android.ui.discussion_comments.adapter;

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
import com.osdb.android.ui.discussion_comments.beans.DiscussionCommentsBean;
import com.osdb.android.ui.discussion_comments.view.DiscussionCommentsActivity;
import com.osdb.android.utils.Utils;
import de.hdodenhof.circleimageview.CircleImageView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DiscussionCommentsAdapter extends RecyclerView.Adapter<DiscussionCommentsAdapter.ViewHolder> {
    private Context context;
    private ArrayList<DiscussionCommentsBean.Comments> dataList;

    public DiscussionCommentsAdapter(Context context, ArrayList<DiscussionCommentsBean.Comments> dataList) {
        this.context = context;
        this.dataList = dataList;
        Log.e("DATA BORN", "" + dataList.size());
    }

    @NonNull
    @Override
    public DiscussionCommentsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.discussion_adapter_item, viewGroup, false);
        return new DiscussionCommentsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiscussionCommentsAdapter.ViewHolder viewHolder, int i) {
        DiscussionCommentsBean.Comments commentsBean = dataList.get(i);
//        Utils.justify(viewHolder.commentTxt);
        viewHolder.playerName.setText(commentsBean.getCreated_by().getName() != null ? commentsBean.getCreated_by().getName() : "");
        if (commentsBean.getComment() != null) {
            String comment = Html.fromHtml(commentsBean.getComment().trim()).toString();
            Log.d("DiscussionAdapter", "onBindViewHolder:    " + comment);
            viewHolder.commentTxt.setText(comment.trim());
        }
        if (commentsBean.getCreated_by() != null && commentsBean.getCreated_by().getAssets() != null
                && commentsBean.getCreated_by().getAssets().size() > 0) {
            RequestOptions requestOptions = new RequestOptions();
            requestOptions.placeholder(R.drawable.img_player_empty);
            Glide.with(context).setDefaultRequestOptions(requestOptions).load(commentsBean.getCreated_by().getAssets().get(0).getFile_name()).into(viewHolder.user_Image);
        }

        long timeInLong = getLongTime(commentsBean.getUpdated_at() != null ? commentsBean.getUpdated_at() : "2019-02-21 03:24:54");

        viewHolder.hours_txt.setText(Utils.getTimeAgo(timeInLong));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView playerName, hours_txt;
        TextView commentTxt;
        RelativeLayout commentMainLay;
        LinearLayout cooment_count_lay;
        CircleImageView user_Image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            playerName = itemView.findViewById(R.id.player_name);
            commentTxt = itemView.findViewById(R.id.comment_txt);
            hours_txt = itemView.findViewById(R.id.hours_txt);
            commentMainLay = itemView.findViewById(R.id.comment_main_lay);
            cooment_count_lay = itemView.findViewById(R.id.cooment_count_lay);
            user_Image = itemView.findViewById(R.id.user_Image);

            if (context instanceof DiscussionCommentsActivity) {
                cooment_count_lay.setVisibility(View.GONE);
            }

//            commentMainLay.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    context.startActivity(new Intent(context, DiscussionCommentsActivity.class)
//                            .putExtra("isInnerComment", false)
//                            .putExtra("id", dataList.get(getAdapterPosition()).getId()));
//                }
//            });
        }
    }

    public void setDataList(ArrayList<DiscussionCommentsBean.Comments> data) {
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

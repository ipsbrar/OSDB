package com.elintminds.osdb.ui.discussion_comments.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.dashboard.beans.DiscussionAdapterBean;
import com.elintminds.osdb.ui.discussion_comments.beans.DiscussionCommentsBean;
import com.elintminds.osdb.ui.discussion_comments.view.DiscussionCommentsActivity;

import java.util.ArrayList;

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

//        Utils.justify(viewHolder.commentTxt);
        viewHolder.playerName.setText(dataList.get(i).getCreated_by().getName());
        viewHolder.commentTxt.setText(Html.fromHtml(dataList.get(i).getComment()));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView playerName;
        TextView commentTxt;
        RelativeLayout commentMainLay;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            playerName = itemView.findViewById(R.id.player_name);
            commentTxt = itemView.findViewById(R.id.comment_txt);
            commentMainLay = itemView.findViewById(R.id.comment_main_lay);

            commentMainLay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.startActivity(new Intent(context, DiscussionCommentsActivity.class)
                            .putExtra("isInnerComment", false)
                            .putExtra("id", dataList.get(getAdapterPosition()).getId()));
                }
            });
        }
    }
    public void setDataList(ArrayList<DiscussionCommentsBean.Comments> data)
    {
        Log.e("DATA",""+data);
        if(data == null || data.isEmpty())
        {
            return;
        }

        this.dataList = data;
        Log.e("DA LIST",""+dataList.size());
    }
}

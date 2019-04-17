package com.osdb.app.ui.discussion_comments.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.osdb.app.R;
import com.osdb.app.ui.discussion_comments.beans.DiscussionCommentsBean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class InnerCommentsAdapter extends RecyclerView.Adapter<InnerCommentsAdapter.ViewHolder> {
    private Context context;
    private ArrayList<DiscussionCommentsBean.Comments> dataList;

    public InnerCommentsAdapter(Context context, ArrayList<DiscussionCommentsBean.Comments> dataList) {
        this.context = context;
        this.dataList = dataList;
        Log.e("DATA BORN", "" + dataList.size());
    }

    @NonNull
    @Override
    public InnerCommentsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.nested_comment_view, viewGroup, false);
        return new InnerCommentsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerCommentsAdapter.ViewHolder viewHolder, int i) {


//        viewHolder.playerName.setText(dataList.get(i).getPlayerName());
//        viewHolder.commentTxt.setText(dataList.get(i).getComment());
//
//        if(i == dataList.size()-1){
//            viewHolder.nestedView.setVisibility(View.GONE);
//        }else{
//            viewHolder.nestedView.setVisibility(View.VISIBLE);
//        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView playerName;
        TextView commentTxt;
        View nestedView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            playerName = itemView.findViewById(R.id.player_name);
            nestedView = itemView.findViewById(R.id.nested_view);
            commentTxt = itemView.findViewById(R.id.comment_txt);



        }
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

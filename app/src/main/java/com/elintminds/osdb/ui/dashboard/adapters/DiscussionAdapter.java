package com.elintminds.osdb.ui.dashboard.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.dashboard.beans.DiscussionAdapterBean;
import com.elintminds.osdb.ui.discussion_comments.view.DiscussionCommentsActivity;
import com.elintminds.osdb.ui.report.view.ReportActivity;
import com.elintminds.osdb.utils.Utils;

import java.util.ArrayList;

public class DiscussionAdapter extends RecyclerView.Adapter<DiscussionAdapter.ViewHolder> {
    private Context context;
    private ArrayList<DiscussionAdapterBean> dataList;

    public DiscussionAdapter(Context context, ArrayList<DiscussionAdapterBean> dataList) {
        this.context = context;
        this.dataList = dataList;
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

        Utils.justify(viewHolder.commentTxt);

        viewHolder.commentMainLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, DiscussionCommentsActivity.class).putExtra("isInnerComment", false));
            }
        });
        viewHolder.reportLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, ReportActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView commentTxt;
        RelativeLayout commentMainLay;
        ;
        LinearLayout reportLay;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            commentTxt = itemView.findViewById(R.id.comment_txt);
            commentMainLay = itemView.findViewById(R.id.comment_main_lay);
            reportLay = itemView.findViewById(R.id.reportLay);


        }
    }


}

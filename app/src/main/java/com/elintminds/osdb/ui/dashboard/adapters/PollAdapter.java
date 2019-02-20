package com.elintminds.osdb.ui.dashboard.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.dashboard.beans.PollAdapterBean;
import com.elintminds.osdb.ui.dashboard.view.DashboardView;

import java.util.ArrayList;

public class PollAdapter extends RecyclerView.Adapter<PollAdapter.ViewHolder> {

    private Context context;
    private ArrayList<PollAdapterBean> dataList;
    DashboardView.PollOptionListner listner;

    public PollAdapter(Context context, ArrayList<PollAdapterBean> dataList, DashboardView.PollOptionListner listner) {
        this.context = context;
        this.dataList = dataList;
        this.listner = listner;
    }

    @NonNull
    @Override
    public PollAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.poll_list_adapter_item, viewGroup, false);
        return new PollAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PollAdapter.ViewHolder holder, final int i) {

        holder.pollOptionParentLay.removeAllViews();
        final ArrayList<String> pollOptionsList = dataList.get(i).getPollOptions();

        for (int j = 0; j < pollOptionsList.size(); j++) {
            View pollOptionView = LayoutInflater.from(context).inflate(R.layout.poll_options_view, null);
            holder.pollOptionParentLay.addView(pollOptionView);
            holder.pollOptionParentLay.setId(j);
            ProgressBar progressBar = pollOptionView.findViewById(R.id.progress_view);
            TextView progressPer = pollOptionView.findViewById(R.id.progress_percentage);
            TextView pollLabel = pollOptionView.findViewById(R.id.poll_label);
            TextView pollName = pollOptionView.findViewById(R.id.poll_name);
            if (dataList.get(i).getVisible()) {
                progressBar.setProgress(40);
                progressPer.setText(progressBar.getProgress()+"%");
                pollName.setTextColor(context.getResources().getColor(R.color.color_white));
                pollLabel.setTextColor(context.getResources().getColor(R.color.color_white));
            } else {
                progressBar.setProgress(0);
                progressPer.setText("");
                pollName.setTextColor(context.getResources().getColor(R.color.color_black));
                pollLabel.setTextColor(context.getResources().getColor(R.color.color_black));
            }


            holder.pollOptionParentLay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dataList.get(i).setVisible(true);
                    listner.onOptionClick(i, view.getId());

                }
            });
        }
    }

    @Override
    public int getItemCount() {
        Log.e("SIZE", "" + dataList.size());
        return dataList.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout pollOptionParentLay;
        TextView pollHeading;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            pollHeading = itemView.findViewById(R.id.poll_heading_text);
            pollOptionParentLay = itemView.findViewById(R.id.poll_option_parent);
        }
    }
}

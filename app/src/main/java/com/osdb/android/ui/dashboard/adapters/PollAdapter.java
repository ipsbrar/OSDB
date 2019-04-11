package com.osdb.android.ui.dashboard.adapters;

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
import com.osdb.android.R;
import com.osdb.android.ui.dashboard.beans.PollAdapterBean;
import com.osdb.android.ui.dashboard.view.DashboardView;
import com.osdb.android.ui.dashboard.view.PollFragment;
import com.osdb.android.utils.AppConstants;

import java.util.ArrayList;
import java.util.List;

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
        PollAdapterBean pollAdapterBean = dataList.get(i);
        holder.pollOptionParentLay.removeAllViews();
        holder.pollHeading.setText(pollAdapterBean.getText() != null ? pollAdapterBean.getText() : "");
        if (pollAdapterBean.getPublishedDate() != null)
            PollFragment.dateTxt.setText(AppConstants.convertDateFormat(pollAdapterBean.getPublishedDate()));
        final List<PollAdapterBean.Option> pollOptionsList = pollAdapterBean.getOptions();
        String[] options = context.getResources().getStringArray(R.array.option_type);
        for (int j = 0; j < pollOptionsList.size(); j++) {
            View pollOptionView = LayoutInflater.from(context).inflate(R.layout.poll_options_view, null);
            holder.pollOptionParentLay.addView(pollOptionView);
            holder.pollOptionParentLay.setId(j);
            ProgressBar progressBar = pollOptionView.findViewById(R.id.progress_view);
            TextView progressPer = pollOptionView.findViewById(R.id.progress_percentage);
            TextView pollLabel = pollOptionView.findViewById(R.id.poll_label);
            TextView pollName = pollOptionView.findViewById(R.id.poll_name);
            pollLabel.setText(options[j]);
            pollLabel.setTextColor(context.getResources().getColor(R.color.color_2E384D));
            pollName.setText(pollOptionsList.get(j).getText());
            if (pollAdapterBean.getResult() != null) {
                progressBar.setProgress(40);
                progressPer.setText(progressBar.getProgress() + "%");
                pollName.setTextColor(context.getResources().getColor(R.color.color_white));
                pollLabel.setTextColor(context.getResources().getColor(R.color.color_white));
            } else {
                progressBar.setProgress(0);
                progressPer.setText("");
                pollName.setTextColor(context.getResources().getColor(R.color.color_2E384D));
                pollLabel.setTextColor(context.getResources().getColor(R.color.color_2E384D));
            }

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

            pollOptionParentLay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //dataList.get(i).setVisible(true);
                    listner.onOptionClick(dataList.get(getAdapterPosition()).getId(), dataList.get(getAdapterPosition()).getOptions().get(view.getId()).getId());

                }
            });
        }
    }

    public void setDataList(ArrayList<PollAdapterBean> adapterBeanArrayList) {

        this.dataList = adapterBeanArrayList;
        notifyDataSetChanged();

    }
}

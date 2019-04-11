package com.osdb.android.ui.team_details_screen.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.osdb.android.R;
import com.osdb.android.ui.team_details_screen.beans.StatsHorizontalBean;

import java.util.List;

public class StatsHorizontalAdapter extends RecyclerView.Adapter<StatsHorizontalAdapter.MyViewHolder> {
    private Context context;
    private List<StatsHorizontalBean> statsHorizontalBeanArrayList;

    public StatsHorizontalAdapter(Context context, List<StatsHorizontalBean> statsHorizontalBeanArrayList) {
        this.context = context;
        this.statsHorizontalBeanArrayList = statsHorizontalBeanArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.stats_horizontal_item, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        StatsHorizontalBean statsHorizontalBean = statsHorizontalBeanArrayList.get(i);
        myViewHolder.txt_content.setText(statsHorizontalBean.getContent() != null ? statsHorizontalBean.getContent() : "");
    }

    @Override
    public int getItemCount() {
        return statsHorizontalBeanArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView txt_content;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_content = itemView.findViewById(R.id.txt_content);
        }
    }


}

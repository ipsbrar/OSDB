package com.osdb.app.ui.team_details_screen.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.osdb.app.R;
import com.osdb.app.ui.team_details_screen.beans.StatsBeans;

import java.util.ArrayList;

public class StatsMainAdapter extends RecyclerView.Adapter<StatsMainAdapter.MyViewHolder> {
    private Context context;
    //    private ArrayList<StatsMainBean> statsMainBeanArrayList;
    private ArrayList<StatsBeans.InnerStatsBean> statsMainBeanArrayList;
    private View viewGroup;

    public StatsMainAdapter(Context context, ArrayList<StatsBeans.InnerStatsBean> statsMainBeanArrayList) {
        this.context = context;
        this.statsMainBeanArrayList = statsMainBeanArrayList;
    }

    @NonNull
    @Override
    public StatsMainAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.stats_main_adapter_layout, viewGroup, false);
        this.viewGroup = view;
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StatsMainAdapter.MyViewHolder myViewHolder, int i) {
        StatsBeans.InnerStatsBean statsMainBean = statsMainBeanArrayList.get(i);
        myViewHolder.txt_header.setText(statsMainBean.getHeaderText() != null ? statsMainBean.getHeaderText() : "");
        myViewHolder.txt_main_header.setText(statsMainBean.getMainHeaderText() != null ? statsMainBean.getMainHeaderText() : "");
        if (statsMainBean.getMainHeaderText().equalsIgnoreCase("invisible")) {
            myViewHolder.txt_main_header.setVisibility(View.GONE);
        }
        if (statsMainBean.getListArrayList() != null && statsMainBean.getListArrayList().size() > 0) {
//            Write code for stats vertical adapter
            myViewHolder.rcv_main_stats.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false) {
                @Override
                public boolean canScrollVertically() {
                    return false;
                }
            });
            myViewHolder.statsVerticalAdapter = new StatsVerticalAdapter(context, statsMainBean.getListArrayList());
            myViewHolder.rcv_main_stats.setAdapter(myViewHolder.statsVerticalAdapter);
        }
    }

    @Override
    public int getItemCount() {
        return statsMainBeanArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView txt_header, txt_main_header;
        private RecyclerView rcv_main_stats;
        private StatsVerticalAdapter statsVerticalAdapter;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            rcv_main_stats = itemView.findViewById(R.id.rcv_main_stats);
            txt_header = itemView.findViewById(R.id.txt_header);
            txt_main_header = itemView.findViewById(R.id.txt_main_header);


        }
    }

    public void setData(ArrayList<StatsBeans.InnerStatsBean> arrayList) {
        this.statsMainBeanArrayList = arrayList;
        notifyDataSetChanged();
    }


}

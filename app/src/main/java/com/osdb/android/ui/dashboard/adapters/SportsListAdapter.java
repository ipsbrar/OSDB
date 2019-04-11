package com.osdb.android.ui.dashboard.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.osdb.android.R;
import com.osdb.android.ui.dashboard.beans.SportsAdapterListBean;
import com.osdb.android.ui.dashboard.view.DashboardView;

import java.util.ArrayList;

public class SportsListAdapter extends RecyclerView.Adapter<SportsListAdapter.ViewHolder> {
    private Context context;
    private ArrayList<SportsAdapterListBean> dataList;
    private DashboardView.SportsAdapterItemClickListener listener;

    public SportsListAdapter(Context context, ArrayList<SportsAdapterListBean> sportsIconsList, DashboardView.SportsAdapterItemClickListener listener) {
        this.context = context;
        this.dataList = sportsIconsList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.sports_list_adapter_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        SportsAdapterListBean item = dataList.get(i);

        holder.sportsName.setText(item.getName());
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.place);
        Glide.with(context).setDefaultRequestOptions(requestOptions).load(item.getLogo().getFileName()).into(holder.sportsIcon);
//        holder.sportsIcon.setImageResource(item.getImgRes());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView sportsIcon;
        TextView sportsName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            sportsIcon = itemView.findViewById(R.id.item_icon);
            sportsName = itemView.findViewById(R.id.sports_name);

            sportsIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onSportsIconClick(getAdapterPosition(), dataList.get(getAdapterPosition()).getName());
                }
            });
        }
    }

    public void setDataList(ArrayList<SportsAdapterListBean> data) {
        if (data == null || data.isEmpty()) {
            return;
        }

        this.dataList = data;
    }
}

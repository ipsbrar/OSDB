package com.osdb.pro.ui.profile.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.osdb.pro.R;
import com.osdb.pro.ui.profile.beans.WatchListBean;

import java.util.ArrayList;

public class WatchListAdapter extends RecyclerView.Adapter<WatchListAdapter.ViewHolder>
{
    private Context context;
    private ArrayList<WatchListBean> dataList;

    public WatchListAdapter(Context context, ArrayList<WatchListBean> dataList)
    {
        this.context = context;
        this.dataList = dataList;
    }


    @NonNull
    @Override
    public WatchListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.watchlist_adapter_item, viewGroup, false);
        return new WatchListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WatchListAdapter.ViewHolder viewHolder, int i)
    {

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
        }
    }
}
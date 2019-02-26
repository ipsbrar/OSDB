package com.elintminds.osdb.ui.profile.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.dashboard.adapters.LiveScroresListAdapter;
import com.elintminds.osdb.ui.dashboard.beans.LiveScroresAdapterBean;
import com.elintminds.osdb.ui.profile.beans.WatchListBean;
import com.elintminds.osdb.ui.search_finding_screen.adapters.PlayerProfileAdapter;
import com.elintminds.osdb.ui.search_finding_screen.beans.PlayersProfileBean;

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
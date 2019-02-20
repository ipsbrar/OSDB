package com.elintminds.osdb.ui.dashboard.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.dashboard.beans.LiveScroresAdapterBean;

import java.util.ArrayList;

public class LiveScroresListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Context context;
    private ArrayList<LiveScroresAdapterBean> dataList;
    private LiveScroresAdapterBean adapterBean;

    public LiveScroresListAdapter(Context context, ArrayList<LiveScroresAdapterBean> dataList) {
        this.context = context;
        this.dataList = dataList;


    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        View view;
        switch (i) {
            case 1: {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.live_soccer_score_view, viewGroup, false);
                return new SoccerViewHolder(view);
            }
            case 2: {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.live_nfl_score_view, viewGroup, false);
                return new NFLViewHolder(view);
            }

        }
        return null;
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {



    }

    @Override
    public int getItemViewType(int position) {

        switch (dataList.get(position).getType()) {
            case 1:
                return 1;
            case 2:
                return 2;
            default:
                return -1;
        }
    }
    @Override
    public int getItemCount() {
        Log.e("SIZE LIST",""+dataList.size());
        return dataList.size();
    }

    public class SoccerViewHolder extends RecyclerView.ViewHolder {
        public SoccerViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public class NFLViewHolder extends RecyclerView.ViewHolder {
        public NFLViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

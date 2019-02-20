package com.elintminds.osdb.ui.dashboard.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.dashboard.beans.BornTodayAdapterBean;
import com.elintminds.osdb.ui.dashboard.beans.SportsAdapterListBean;

import java.util.ArrayList;

public class BornTodayAdapter extends RecyclerView.Adapter<BornTodayAdapter.ViewHolder>
{
    private Context context;
    private ArrayList<BornTodayAdapterBean> dataList;

    public BornTodayAdapter(Context context, ArrayList<BornTodayAdapterBean> dataList)
    {
        this.context = context;
        this.dataList = dataList;
        Log.e("DATA BORN",""+dataList.size());
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.born_today_adapter_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

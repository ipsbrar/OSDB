package com.osdb.pro.ui.profile.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.osdb.pro.R;
import com.osdb.pro.ui.dashboard.beans.NewsAdapterBean;

import java.util.ArrayList;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder>
{
    private Context context;
    private ArrayList<NewsAdapterBean> dataList;

    public NotificationAdapter(Context context, ArrayList<NewsAdapterBean> dataList)
    {
        this.context = context;
        this.dataList = dataList;
    }


    @NonNull
    @Override
    public NotificationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.notification_item_view, viewGroup, false);
        return new NotificationAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationAdapter.ViewHolder viewHolder, int i)
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

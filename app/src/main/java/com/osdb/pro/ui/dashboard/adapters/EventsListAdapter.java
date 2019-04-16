package com.osdb.pro.ui.dashboard.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.osdb.pro.R;
import com.osdb.pro.ui.dashboard.beans.EventsAdapterBean;
import com.osdb.pro.ui.dashboard.view.DashboardView;

import java.util.ArrayList;

public class EventsListAdapter extends RecyclerView.Adapter<EventsListAdapter.ViewHolder>
{
    private Context context;
    private ArrayList<EventsAdapterBean> dataList;
    private DashboardView.EventsItemsClickListener listener;

    public EventsListAdapter(Context context, ArrayList<EventsAdapterBean> dataList, DashboardView.EventsItemsClickListener listener)
    {
        this.context = context;
        this.dataList = dataList;
        this.listener =  listener;
    }


    @NonNull
    @Override
    public EventsListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.events_adapter_item, viewGroup, false);
        return new EventsListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventsListAdapter.ViewHolder holder, int i)
    {
        EventsAdapterBean item = dataList.get(i);
        holder.eventTitle.setText(item.getTitle());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView eventTitle, showDetailsBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            eventTitle = itemView.findViewById(R.id.event_title);
            showDetailsBtn = itemView.findViewById(R.id.show_details);

            showDetailsBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onShowDetailsClick(getAdapterPosition());
                }
            });
        }
    }

    public void setDataList(ArrayList<EventsAdapterBean> data)
    {
        Log.e("DATA",""+data);
        if(data == null || data.isEmpty())
        {
            return;
        }

        this.dataList = data;
        Log.e("DA LIST",""+dataList.size());
    }
}

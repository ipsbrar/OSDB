package com.elintminds.osdb.ui.dashboard.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.dashboard.beans.SportsAdapterListBean;

import java.util.ArrayList;

public class SportsListAdapter extends RecyclerView.Adapter<SportsListAdapter.ViewHolder>
{
    private Context context;
    private ArrayList<SportsAdapterListBean> dataList;

    public SportsListAdapter(Context context, ArrayList<SportsAdapterListBean> sportsIconsList)
    {
        this.context = context;
        this.dataList = sportsIconsList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.sports_list_adapter_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i)
    {
        SportsAdapterListBean item = dataList.get(i);

        //holder.sportsName.setText(item.getGameName());
        holder.sportsIcon.setImageResource(item.getImgRes());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView sportsIcon;
        TextView sportsName;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            sportsIcon = itemView.findViewById(R.id.item_icon);
            sportsName = itemView.findViewById(R.id.sports_name);
        }
    }
}

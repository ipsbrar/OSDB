package com.osdb.android.ui.profile.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.osdb.android.R;

import com.osdb.android.ui.search_screen.beans.SearchBean;

import java.util.ArrayList;

public class FollowingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    private static final int HEADING_TYPE = 101;
    private static final int ITEM_TYPE = 102;

    private Context context;
    private ArrayList<SearchBean> dataList;

    public FollowingAdapter(Context context, ArrayList<SearchBean> dataList)
    {
        this.context = context;
        this.dataList = dataList;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        if(i == HEADING_TYPE)
        {
            View view = LayoutInflater.from(context).inflate(R.layout.following_adapter_header_view, viewGroup, false);
            return new FollowingAdapter.HeaderViewHolder(view);
        }
        else if(i == ITEM_TYPE)
        {
            View view = LayoutInflater.from(context).inflate(R.layout.following_adapter_item_view, viewGroup, false);
            return new FollowingAdapter.ItemViewHolder(view);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i)
    {
        SearchBean item = dataList.get(i);
        if(viewHolder instanceof FollowingAdapter.HeaderViewHolder)
        {
            ((FollowingAdapter.HeaderViewHolder) viewHolder).headerTV.setText(item.getSearchName());
        }
        else if(viewHolder instanceof FollowingAdapter.ItemViewHolder)
        {
            ((FollowingAdapter.ItemViewHolder) viewHolder).itemTV.setText(item.getSearchName());
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    @Override
    public int getItemViewType(int position) {
        return dataList.get(position).getSearchType();
    }

    public class HeaderViewHolder extends RecyclerView.ViewHolder
    {
        TextView headerTV;

        public HeaderViewHolder(@NonNull View itemView)
        {
            super(itemView);
            headerTV = itemView.findViewById(R.id.search_heading);
        }
    }

    public class ItemViewHolder extends  RecyclerView.ViewHolder
    {
        TextView itemTV;
        View divider;
        public ItemViewHolder(@NonNull View itemView)
        {
            super(itemView);
            itemTV = itemView.findViewById(R.id.teamName);


        }
    }
}

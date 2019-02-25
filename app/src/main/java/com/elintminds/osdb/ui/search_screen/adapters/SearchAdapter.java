package com.elintminds.osdb.ui.search_screen.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.search_screen.beans.SearchBean;
import com.elintminds.osdb.ui.search_screen.view.SearchScreenView;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    public static final int HEADING_TYPE = 101;
    public static final int ITEM_TYPE = 102;

    private Context context;
    private ArrayList<SearchBean> dataList;
    private SearchScreenView.SearchItemClickListener listener;

    public SearchAdapter(Context context, ArrayList<SearchBean> dataList, SearchScreenView.SearchItemClickListener listener)
    {
        this.context = context;
        this.dataList = dataList;
        this.listener = listener;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        if(i == HEADING_TYPE)
        {
            View view = LayoutInflater.from(context).inflate(R.layout.search_adapter_header_view, viewGroup, false);
            return new HeaderViewHolder(view);
        }
        else if(i == ITEM_TYPE)
        {
            View view = LayoutInflater.from(context).inflate(R.layout.search_adapter_item_view, viewGroup, false);
            return new ItemViewHolder(view);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i)
    {
        SearchBean item = dataList.get(i);
        if(viewHolder instanceof HeaderViewHolder)
        {
            ((HeaderViewHolder) viewHolder).headerTV.setText(item.getSearchName());
        }
        else if(viewHolder instanceof ItemViewHolder)
        {
            ((ItemViewHolder) viewHolder).itemTV.setText(item.getSearchName());
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
            itemTV = itemView.findViewById(R.id.search_item);
            divider = itemView.findViewById(R.id.search_adapter_divider);

            itemTV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    listener.onItemClick(getAdapterPosition());
                }
            });
        }
    }
}

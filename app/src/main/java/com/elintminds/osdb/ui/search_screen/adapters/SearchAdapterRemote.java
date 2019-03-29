package com.elintminds.osdb.ui.search_screen.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.search_screen.beans.SearchAdapterRemoteBean;
import com.elintminds.osdb.ui.search_screen.view.SearchScreenView;

import java.util.ArrayList;

public class SearchAdapterRemote extends RecyclerView.Adapter<SearchAdapterRemote.MyViewHolder> {

    private ArrayList<SearchAdapterRemoteBean> searchAdapterRemoteBeanArrayList;
    private Context context;
    private SearchScreenView.SearchItemClickListener searchItemClickListener;

    public SearchAdapterRemote(ArrayList<SearchAdapterRemoteBean> searchAdapterRemoteBeanArrayList, Context context, SearchScreenView.SearchItemClickListener searchItemClickListener) {
        this.searchAdapterRemoteBeanArrayList = searchAdapterRemoteBeanArrayList;
        this.context = context;
        this.searchItemClickListener = searchItemClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.search_adapter_item_view, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        SearchAdapterRemoteBean searchAdapterRemoteBean = searchAdapterRemoteBeanArrayList.get(i);
        if (searchAdapterRemoteBean.getType().equalsIgnoreCase("News")) {
            myViewHolder.itemTV.setText(searchAdapterRemoteBean.getTags());
        } else if (searchAdapterRemoteBean.getType().equalsIgnoreCase("Player")) {
            myViewHolder.itemTV.setText(searchAdapterRemoteBean.getPlayerName());
        } else {
            myViewHolder.itemTV.setText(searchAdapterRemoteBean.getPlayerTeam());
        }
    }

    @Override
    public int getItemCount() {
        return searchAdapterRemoteBeanArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView itemTV;
        private LinearLayout ll_click_item;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemTV = itemView.findViewById(R.id.search_item);
            ll_click_item = itemView.findViewById(R.id.ll_click_item);

            ll_click_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    searchItemClickListener.onItemClickRemote(searchAdapterRemoteBeanArrayList.get(getAdapterPosition()));
                }
            });
        }
    }

    public void changeData(ArrayList<SearchAdapterRemoteBean> searchAdapterRemoteBeans) {
        this.searchAdapterRemoteBeanArrayList = searchAdapterRemoteBeans;
        notifyDataSetChanged();
    }
}

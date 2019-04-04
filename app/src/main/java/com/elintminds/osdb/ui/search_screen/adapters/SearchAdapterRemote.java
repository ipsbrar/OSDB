package com.elintminds.osdb.ui.search_screen.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.search_screen.beans.SearchAdapterRemoteBean;
import com.elintminds.osdb.ui.search_screen.beans.SearchBean;
import com.elintminds.osdb.ui.search_screen.view.SearchScreenView;

import java.util.ArrayList;

public class SearchAdapterRemote extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int HEADING_TYPE = 101;
    public static final int ITEM_TYPE = 102;

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
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.d("SearchAdapter", "onCreateViewHolder: " + i);
        if (i == HEADING_TYPE) {
            View view = LayoutInflater.from(context).inflate(R.layout.search_adapter_header_view, viewGroup, false);
            return new HeaderViewHolder(view);
        } else if (i == ITEM_TYPE) {
            View view = LayoutInflater.from(context).inflate(R.layout.search_adapter_item_view, viewGroup, false);
            return new ItemViewHolder(view);
        }

        return null;
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        SearchAdapterRemoteBean searchAdapterRemoteBean = searchAdapterRemoteBeanArrayList.get(i);

        if (viewHolder instanceof HeaderViewHolder) {
            ((HeaderViewHolder) viewHolder).headerTV.setText(searchAdapterRemoteBean.getType() != null ? searchAdapterRemoteBean.getType() : "");
        } else if (viewHolder instanceof ItemViewHolder) {
            if (searchAdapterRemoteBean.getType().equalsIgnoreCase("News")) {
                ((ItemViewHolder) viewHolder).user_name.setText(searchAdapterRemoteBean.getTags());
            } else if (searchAdapterRemoteBean.getType().equalsIgnoreCase("Player")) {
                ((ItemViewHolder) viewHolder).user_name.setText(searchAdapterRemoteBean.getPlayerName());
            } else {
                ((ItemViewHolder) viewHolder).user_name.setText(searchAdapterRemoteBean.getPlayerTeam());
            }
            ((ItemViewHolder) viewHolder).slug_name.setText(searchAdapterRemoteBean.getSlugName());
            if (searchAdapterRemoteBean.getImgUrl() != null) {
                RequestOptions requestOptions = new RequestOptions();
                requestOptions.placeholder(R.drawable.img_player_empty);
                Glide.with(context).setDefaultRequestOptions(requestOptions).load(searchAdapterRemoteBean.getImgUrl()).into(((ItemViewHolder) viewHolder).team_logo);
            }

        }
    }

    @Override
    public int getItemCount() {
        return searchAdapterRemoteBeanArrayList.size();
    }


    public void changeData(ArrayList<SearchAdapterRemoteBean> searchAdapterRemoteBeans) {
        this.searchAdapterRemoteBeanArrayList = searchAdapterRemoteBeans;
        notifyDataSetChanged();
    }


    @Override
    public int getItemViewType(int position) {
        return searchAdapterRemoteBeanArrayList.get(position).getSearchType();
    }

    public class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView headerTV;

        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            headerTV = itemView.findViewById(R.id.search_heading);
        }
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView slug_name, user_name;
        private ImageView team_logo;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            slug_name = itemView.findViewById(R.id.slug_name);
            user_name = itemView.findViewById(R.id.user_name);
            team_logo = itemView.findViewById(R.id.team_logo);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    searchItemClickListener.onItemClickRemote(searchAdapterRemoteBeanArrayList.get(getAdapterPosition()));
                }
            });
        }
    }
}

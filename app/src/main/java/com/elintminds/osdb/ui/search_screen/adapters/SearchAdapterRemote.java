package com.elintminds.osdb.ui.search_screen.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.search_screen.beans.SearchAdapterRemoteBean;
import com.elintminds.osdb.ui.search_screen.beans.SearchBean;
import com.elintminds.osdb.ui.search_screen.view.SearchScreenView;
import com.elintminds.osdb.utils.Tag;
import com.elintminds.osdb.utils.TagView;

import java.util.ArrayList;
import java.util.List;

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
            ((ItemViewHolder) viewHolder).tag_group.removeAll();
            if (searchAdapterRemoteBean.getType().equalsIgnoreCase("News")) {
                ((ItemViewHolder) viewHolder).rl_other.setVisibility(View.GONE);
                ((ItemViewHolder) viewHolder).rl_news_layout.setVisibility(View.VISIBLE);
                ((ItemViewHolder) viewHolder).txt_news_title.setText(searchAdapterRemoteBean.getTitle());
                if (searchAdapterRemoteBean.getStringArrayList() != null && searchAdapterRemoteBean.getStringArrayList().length > 0) {
                    Log.e("AdapterPositionIsThis", "     " + searchAdapterRemoteBean.getStringArrayList().length);
                    ((ItemViewHolder) viewHolder).tag_group.addTags(getTagList(searchAdapterRemoteBean.getStringArrayList()));
                }
            } else if (searchAdapterRemoteBean.getType().equalsIgnoreCase("Player")) {
                ((ItemViewHolder) viewHolder).rl_other.setVisibility(View.VISIBLE);
                ((ItemViewHolder) viewHolder).rl_news_layout.setVisibility(View.GONE);
                ((ItemViewHolder) viewHolder).user_name.setText(searchAdapterRemoteBean.getPlayerName());
            } else {
                ((ItemViewHolder) viewHolder).rl_other.setVisibility(View.VISIBLE);
                ((ItemViewHolder) viewHolder).rl_news_layout.setVisibility(View.GONE);
                ((ItemViewHolder) viewHolder).user_name.setText(searchAdapterRemoteBean.getPlayerTeam());
            }

            ((ItemViewHolder) viewHolder).slug_name.setText(searchAdapterRemoteBean.getSlugName());

            if (searchAdapterRemoteBean.getImgUrl() != null) {
                RequestOptions requestOptions = new RequestOptions();
                if (searchAdapterRemoteBean.getType().equalsIgnoreCase("News"))
                    requestOptions.placeholder(R.drawable.place);
                else
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
        private TextView slug_name, user_name, txt_news_title;
        private ImageView team_logo;
        private RelativeLayout rl_news_layout, rl_other;
        private TagView tag_group;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            slug_name = itemView.findViewById(R.id.slug_name);
            user_name = itemView.findViewById(R.id.user_name);
            team_logo = itemView.findViewById(R.id.team_logo);
            txt_news_title = itemView.findViewById(R.id.txt_news_title);
            rl_news_layout = itemView.findViewById(R.id.rl_news_layout);
            rl_other = itemView.findViewById(R.id.rl_other);
            tag_group = itemView.findViewById(R.id.tag_group);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    searchItemClickListener.onItemClickRemote(searchAdapterRemoteBeanArrayList.get(getAdapterPosition()));
                }
            });
        }
    }

    private List<Tag> getTagList(String[] strings) {
        List<Tag> tagList = new ArrayList<>();
        for (int j = 0; j < strings.length; j++) {
            Tag tag = new Tag(strings[j]);
            tag.setBackground(context.getDrawable(R.drawable.follow_following_btn_bg));
            tagList.add(tag);
        }
        return tagList;
    }
}

package com.elintminds.osdb.ui.player_details_screen.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.player_details_screen.beans.CharityCommunityBeans;

import java.util.ArrayList;

public class CharityCommunityAdapter extends RecyclerView.Adapter<CharityCommunityAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<CharityCommunityBeans> dataList;

    public CharityCommunityAdapter(Context context, ArrayList<CharityCommunityBeans> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_charity_community, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        CharityCommunityBeans charityCommunityBeans = dataList.get(i);
        myViewHolder.news_title.setText(charityCommunityBeans.getContentText() != null ? charityCommunityBeans.getContentText() : "");
        if (charityCommunityBeans.getImgUrl() != null) {
            RequestOptions requestOptions = new RequestOptions();
            requestOptions.placeholder(R.drawable.place);
            Glide.with(context).setDefaultRequestOptions(requestOptions).load(charityCommunityBeans.getImgUrl()).into(myViewHolder.news_preview_image);
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView news_preview_image;
        private TextView news_title;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            news_preview_image = itemView.findViewById(R.id.news_preview_image);
            news_title = itemView.findViewById(R.id.news_title);
        }
    }
}

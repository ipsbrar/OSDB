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
import com.elintminds.osdb.ui.player_details_screen.beans.VideosBean;
import com.elintminds.osdb.ui.player_details_screen.view.PlayerDetailsView;

import java.util.ArrayList;

public class VideosAdapter extends RecyclerView.Adapter<VideosAdapter.ViewHolder> {
    private Context context;
    private ArrayList<VideosBean> dataList;
    private PlayerDetailsView.VideoPhotoAdapterListener listener;

    public VideosAdapter(Context context, ArrayList<VideosBean> dataList, PlayerDetailsView.VideoPhotoAdapterListener listener) {
        this.context = context;
        this.dataList = dataList;
        this.listener = listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.videos_adapter_item_view, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        VideosBean videosBean = dataList.get(i);


        if (videosBean.getThumbnail() != null) {
            RequestOptions requestOptions = new RequestOptions();
            requestOptions.placeholder(R.drawable.ic_latest);
            Glide.with(context).setDefaultRequestOptions(requestOptions).load(videosBean.getThumbnail()).into(holder.video_thumbnail);
        }
        holder.video_title.setText(videosBean.getVideoTitle() != null ? videosBean.getVideoTitle() : "");
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView video_thumbnail;
        private TextView video_title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            video_thumbnail = itemView.findViewById(R.id.video_thumbnail);
            video_title = itemView.findViewById(R.id.video_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(getAdapterPosition());
                }
            });
        }
    }

    public void setDataList(ArrayList<VideosBean> data) {
        if (data == null || data.isEmpty()) {
            return;
        }

        this.dataList = data;
    }
}

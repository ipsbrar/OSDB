package com.osdb.app.ui.dashboard.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.osdb.app.R;
import com.osdb.app.ui.dashboard.beans.NewsAdapterBean;
import com.osdb.app.ui.dashboard.view.DashboardView;
import com.osdb.app.utils.Utils;

import java.util.ArrayList;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.ViewHolder> {
    private Context context;
    private ArrayList<NewsAdapterBean.Datum> dataList;
    private DashboardView.NewsItemsClickListener listener;

    public NewsListAdapter(Context context, ArrayList<NewsAdapterBean.Datum> dataList, DashboardView.NewsItemsClickListener listener) {
        this.context = context;
        this.dataList = dataList;
        this.listener = listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_adapter_item, viewGroup, false);
        return new NewsListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        NewsAdapterBean.Datum item = dataList.get(i);
        if (item.getImageUrl() != null) {
            String newsUrl = item.getImageUrl();
            if (!newsUrl.contains(".jpg")) {
                newsUrl = newsUrl.concat(".jpg");
            }
            RequestOptions requestOptions = new RequestOptions();
            requestOptions.placeholder(R.drawable.place);

            Glide.with(context).setDefaultRequestOptions(requestOptions).load(newsUrl).into(holder.newsPreviewImage);
            if (item.getNewsType() != null && item.getNewsType().equalsIgnoreCase("video")) {
                holder.video_icon.setVisibility(View.VISIBLE);
            } else {
                holder.video_icon.setVisibility(View.GONE);
            }
        } else {
            if (item.getAsset() != null) {
                RequestOptions requestOptions = new RequestOptions();
                requestOptions.placeholder(R.drawable.place);
                Log.e("Image_Path_news", item.getAsset().getFileName());
                String newsUrl = item.getAsset().getFileName();
                if (!newsUrl.contains(".jpg")) {
                    newsUrl = newsUrl.concat(".jpg");
                }
//
                Log.e("NewsType", newsUrl);


                Glide.with(context).setDefaultRequestOptions(requestOptions).load(newsUrl).into(holder.newsPreviewImage);
                if (item.getAsset().getFileType() == 4) {
                    holder.video_icon.setVisibility(View.VISIBLE);
                } else {
                    holder.video_icon.setVisibility(View.GONE);
                }
            }
        }
        if (item.getTitle() != null) {
            holder.newsTitle.setText(item.getTitle());

        }
        holder.txt_source.setText("By: " + item.getSource());
        if (item.getCreatedAt() != null && !TextUtils.isEmpty(item.getCreatedAt())) {
            holder.newsDateTime.setText(Utils.getFormatedDate(item.getCreatedAt()
                    , "yyyy-MM-dd hh:mm:ss"
                    , "MMM. dd, yyyy"));
        }


    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView newsPreviewImage, video_icon;
        TextView newsTitle, newsDateTime, txt_source;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            newsPreviewImage = itemView.findViewById(R.id.news_preview_image);
            newsTitle = itemView.findViewById(R.id.news_title);
            newsDateTime = itemView.findViewById(R.id.news_date_time);
            txt_source = itemView.findViewById(R.id.txt_source);
            video_icon = itemView.findViewById(R.id.video_icon);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onNewsClick(getAdapterPosition());
                }
            });
        }
    }

    public void setDataList(ArrayList<NewsAdapterBean.Datum> data) {
        Log.e("DATA", "" + data);
        if (data == null || data.isEmpty()) {
            return;
        }

        this.dataList = data;
        Log.e("DA LIST", "" + dataList.size());
    }
}

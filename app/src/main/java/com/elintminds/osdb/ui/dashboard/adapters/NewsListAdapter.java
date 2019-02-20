package com.elintminds.osdb.ui.dashboard.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.dashboard.beans.NewsAdapterBean;
import com.elintminds.osdb.ui.dashboard.view.DashboardView;

import java.util.ArrayList;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.ViewHolder>
{
    private Context context;
    private ArrayList<NewsAdapterBean> dataList;
    private DashboardView.NewsItemsClickListener listener;

    public NewsListAdapter(Context context, ArrayList<NewsAdapterBean> dataList, DashboardView.NewsItemsClickListener listener)
    {
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
    public void onBindViewHolder(@NonNull ViewHolder holder, int i)
    {
        NewsAdapterBean item = dataList.get(i);
        holder.newsTitle.setText(item.getTitle());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView newsPreviewImage;
        TextView newsTitle, newsDateTime;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            newsPreviewImage = itemView.findViewById(R.id.news_preview_image);
            newsTitle = itemView.findViewById(R.id.news_title);
            newsDateTime = itemView.findViewById(R.id.news_date_time);

            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    listener.onNewsClick(getAdapterPosition());
                }
            });
        }
    }

    public void setDataList(ArrayList<NewsAdapterBean> data)
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

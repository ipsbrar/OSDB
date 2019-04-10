package com.elintminds.osdb.ui.dashboard.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.dashboard.Interfaces.DoYouKnowOnClick;
import com.elintminds.osdb.ui.dashboard.beans.HomeBean;

import java.util.ArrayList;

public class DoYouKnowAdapter extends RecyclerView.Adapter<DoYouKnowAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<HomeBean.DidYouKnow> dataList;
    private DoYouKnowOnClick doYouKnowOnClick;

    public DoYouKnowAdapter(Context context, ArrayList<HomeBean.DidYouKnow> dataList,DoYouKnowOnClick doYouKnowOnClick) {
        this.context = context;
        this.dataList = dataList;
        this.doYouKnowOnClick = doYouKnowOnClick;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_do_you_know, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        HomeBean.DidYouKnow didYouKnow = dataList.get(i);
        myViewHolder.view_5_msg_text.setText(Html.fromHtml(didYouKnow.getContent()).toString());

        if (didYouKnow.getAssets() != null && didYouKnow.getAssets().size() > 0) {
            RequestOptions requestOptions = new RequestOptions();
            requestOptions.placeholder(R.drawable.place);
            Glide.with(context).setDefaultRequestOptions(requestOptions)
                    .load(didYouKnow.getAssets().get(0).getFileName()).into(myViewHolder.view_5_image);
        } else {
            Glide.with(context)
                    .load(R.drawable.place).into(myViewHolder.view_5_image);
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView view_5_image;
        private TextView view_5_msg_text;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            view_5_image = itemView.findViewById(R.id.player_image);
            view_5_msg_text = itemView.findViewById(R.id.news_title);

            itemView.findViewById(R.id.cv_born_today).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    doYouKnowOnClick.doYouItemOnCLick(dataList.get(getAdapterPosition()));
                }
            });
        }
    }
}

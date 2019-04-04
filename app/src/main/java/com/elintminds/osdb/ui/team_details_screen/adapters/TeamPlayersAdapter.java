package com.elintminds.osdb.ui.team_details_screen.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.elintminds.osdb.R;
import com.elintminds.osdb.data.network.WebserviceUrls;
import com.elintminds.osdb.ui.dashboard.beans.HomeBean;
import com.elintminds.osdb.ui.team_details_screen.beans.TeamPlayersBean;
import com.elintminds.osdb.ui.team_details_screen.view.TeamDetailsView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TeamPlayersAdapter extends RecyclerView.Adapter<TeamPlayersAdapter.ViewHolder> {
    private Context context;
    private ArrayList<TeamPlayersBean.Player> dataList;
    private TeamDetailsView.TeamPlayersAdapterListener listener;

    public TeamPlayersAdapter(Context context, ArrayList<TeamPlayersBean.Player> dataList, TeamDetailsView.TeamPlayersAdapterListener listener) {
        this.context = context;
        this.dataList = dataList;
        this.listener = listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.team_player_adapter_view, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        TeamPlayersBean.Player item = dataList.get(i);
        viewHolder.playerName.setText(item.getFullName());
        if (item.getHeadshots() != null && !item.getHeadshots().equalsIgnoreCase("")) {
            try {
                JSONArray jsonArray = new JSONArray(item.getHeadshots());
                    JSONObject jsonObject = jsonArray.getJSONObject(0);
                    String imgUrl = jsonObject.getString("href");
                    String urlImg = "https://s3-us-west-2.amazonaws.com/osdb/" + imgUrl;
                    Log.e("MYIMAGEURL", urlImg);
                    RequestOptions requestOptions = new RequestOptions();
                    requestOptions.placeholder(R.drawable.img_player_empty);

                    Glide.with(context).setDefaultRequestOptions(requestOptions).load(urlImg).into(viewHolder.player_image);


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView playerName;
        private ImageView player_image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            playerName = itemView.findViewById(R.id.player_name);
            player_image = itemView.findViewById(R.id.player_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onPlayerItemClick(getAdapterPosition());
                }
            });
        }
    }


    public void setDataList(ArrayList<TeamPlayersBean.Player> data) {
        if (data == null || data.isEmpty()) {
            return;
        }

        this.dataList = data;
    }
}

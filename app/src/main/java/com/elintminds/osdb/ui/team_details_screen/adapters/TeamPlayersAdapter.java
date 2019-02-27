package com.elintminds.osdb.ui.team_details_screen.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.team_details_screen.beans.TeamPlayersBean;
import com.elintminds.osdb.ui.team_details_screen.view.TeamDetailsView;

import java.util.ArrayList;

public class TeamPlayersAdapter extends RecyclerView.Adapter<TeamPlayersAdapter.ViewHolder>
{
    private Context context;
    private ArrayList<TeamPlayersBean> dataList;
    private TeamDetailsView.TeamPlayersAdapterListener listener;

    public TeamPlayersAdapter(Context context, ArrayList<TeamPlayersBean> dataList, TeamDetailsView.TeamPlayersAdapterListener listener)
    {
        this.context = context;
        this.dataList = dataList;
        this.listener = listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.team_player_adapter_view, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i)
    {
        TeamPlayersBean item = dataList.get(i);
        viewHolder.playerName.setText(item.getPlayerName());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView playerName;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            playerName = itemView.findViewById(R.id.player_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onPlayerItemClick(getAdapterPosition());
                }
            });
        }
    }
}

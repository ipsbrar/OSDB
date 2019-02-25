package com.elintminds.osdb.ui.search_finding_screen.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.search_finding_screen.beans.PlayersProfileBean;

import java.util.ArrayList;

public class PlayerProfileAdapter extends RecyclerView.Adapter<PlayerProfileAdapter.ViewHolder>
{
    private Context context;
    private ArrayList<PlayersProfileBean> dataList;

    public PlayerProfileAdapter(Context context, ArrayList<PlayersProfileBean> dataList)
    {
        this.context = context;
        this.dataList = dataList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.player_profile_adapter_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i)
    {
        PlayersProfileBean item = dataList.get(i);
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
        }
    }
}

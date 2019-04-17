package com.osdb.app.ui.player_details_screen.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.osdb.app.R;

import java.util.ArrayList;

public class CareerAdapter extends RecyclerView.Adapter<CareerAdapter.ViewHolder>
{
    private Context context;
    private ArrayList<String> dataList;

    public CareerAdapter(Context context, ArrayList<String> dataList)
    {
        this.context = context;
        this.dataList = dataList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.career_adapter_item_view, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i)
    {
        viewHolder.achievementText.setText(dataList.get(i));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView achievementText;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            achievementText = itemView.findViewById(R.id.achivement_txt);
        }
    }
}

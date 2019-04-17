package com.osdb.app.ui.search_screen.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.osdb.app.R;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyViewHolder> {
    public static final int HEADING_TYPE = 101;
    public static final int ITEM_TYPE = 102;

    private Context context;
    private String[] dataList;


    public SearchAdapter(Context context, String[] dataList) {
        this.context = context;
        this.dataList = dataList;

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_strugger_layout, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.txt_strugger.setText(dataList[i]);
    }

    @Override
    public int getItemCount() {
        return dataList.length;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView txt_strugger;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_strugger = itemView.findViewById(R.id.txt_strugger);
        }
    }
}

package com.osdb.app.ui.team_details_screen.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.osdb.app.R;

import java.util.ArrayList;
import java.util.List;

public class StatsVerticalAdapter extends RecyclerView.Adapter<StatsVerticalAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<List<String>> listArrayList;



    public StatsVerticalAdapter(Context context, ArrayList<List<String>> listArrayList) {
        this.context = context;
        this.listArrayList = listArrayList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.stats_vertical_item, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
//            write code for horizontal layout
            for (int j = 0; j < listArrayList.get(i).size(); j++) {
                setNormalText(listArrayList.get(i).get(j), i, myViewHolder.ll_linear_layout, true);
        }
    }

    @Override
    public int getItemCount() {
        return listArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout ll_linear_layout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ll_linear_layout = itemView.findViewById(R.id.ll_linear_layout);
        }
    }

    private void setNormalText(String text, int id, LinearLayout linearLayout, boolean isHeader) {

        ViewGroup.LayoutParams lparams = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        TextView tv = new TextView(context);
        tv.setLayoutParams(lparams);
        if (text.length() > 4 && id > 0) {
            String upToNCharacters = text.substring(0, Math.min(text.length(), 4));
            tv.setText(upToNCharacters);
        } else {
            tv.setText(text);
        }
        tv.setPadding(20, 10, 20, 10);
        tv.setGravity(Gravity.CENTER);
        linearLayout.addView(tv);
    }
}

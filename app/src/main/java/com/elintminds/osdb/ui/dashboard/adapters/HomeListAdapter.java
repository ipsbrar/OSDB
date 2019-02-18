package com.elintminds.osdb.ui.dashboard.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.dashboard.beans.HomeAdapterListBean;

import java.util.ArrayList;

public class HomeListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    private Context context;
    private ArrayList<HomeAdapterListBean> dataList;

    public HomeListAdapter(Context context, ArrayList<HomeAdapterListBean> dataList)
    {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        if(i == 1) {
            View view = LayoutInflater.from(context).inflate(R.layout.home_adapter_first_layout, viewGroup, false);
            return new FirstViewHolder(view);
        }else if(i == 2) {
            View view = LayoutInflater.from(context).inflate(R.layout.home_adapter_second_layout, viewGroup, false);
            return new SecondViewHolder(view);
        }else  if(i == 3) {
            View view = LayoutInflater.from(context).inflate(R.layout.home_adapter_third_layout, viewGroup, false);
            return new ThirdViewHolder(view);
        }else if(i == 4) {
            View view = LayoutInflater.from(context).inflate(R.layout.home_adapter_fourth_layout, viewGroup, false);
            return new FourthViewHolder(view);
        }else if(i == 5) {
            View view = LayoutInflater.from(context).inflate(R.layout.home_adapter_fifth_layout, viewGroup, false);
            return new FifthViewHolder(view);
        }else if(i == 6) {
            View view = LayoutInflater.from(context).inflate(R.layout.home_adapter_sixth_layout, viewGroup, false);
            return new SixthViewHolder(view);
        }else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i)
    {

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        HomeAdapterListBean item = dataList.get(position);
        return Integer.parseInt(item.getType());
    }

    public class FirstViewHolder extends RecyclerView.ViewHolder{
        public FirstViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }


    public class SecondViewHolder extends RecyclerView.ViewHolder{
        public SecondViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public class ThirdViewHolder extends RecyclerView.ViewHolder{
        public ThirdViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public class FourthViewHolder extends RecyclerView.ViewHolder{
        public FourthViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public class FifthViewHolder extends RecyclerView.ViewHolder{
        public FifthViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public class SixthViewHolder extends RecyclerView.ViewHolder{
        public SixthViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }


}

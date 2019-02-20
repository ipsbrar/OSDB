package com.elintminds.osdb.ui.dashboard.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.dashboard.beans.BornTodayAdapterBean;
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
        Log.e("DATA SIZE",""+dataList.size());
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
        if(viewHolder instanceof SecondViewHolder)
        {
            ArrayList<BornTodayAdapterBean> dataItems = new ArrayList<>(10);
            for (int j=0; j<10; j++){
                BornTodayAdapterBean item = new BornTodayAdapterBean();

                dataItems.add(item);
            }
            BornTodayAdapter adapter = new BornTodayAdapter(context, dataItems);
            ((SecondViewHolder) viewHolder).bornTodayRecycler.setNestedScrollingEnabled(false);
            ((SecondViewHolder) viewHolder).bornTodayRecycler.setAdapter(adapter);
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        Log.e("Position",""+position+", "+dataList.size());
        HomeAdapterListBean item = dataList.get(position);
        Log.e("TYPE",""+item.getType());
        return Integer.parseInt(item.getType());
    }

    public class FirstViewHolder extends RecyclerView.ViewHolder{
        public FirstViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }


    public class SecondViewHolder extends RecyclerView.ViewHolder
    {
        RecyclerView bornTodayRecycler;
        public SecondViewHolder(@NonNull View itemView) {
            super(itemView);
            bornTodayRecycler = itemView.findViewById(R.id.born_today_recycler);
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

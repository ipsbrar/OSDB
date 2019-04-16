package com.osdb.pro.ui.profile.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.osdb.pro.R;
import com.osdb.pro.ui.base.view.BaseFragment;
import com.osdb.pro.ui.profile.adapter.WatchListAdapter;
import com.osdb.pro.ui.profile.beans.WatchListBean;


import java.util.ArrayList;

public class MyWatchListFragment extends BaseFragment {

    public static final String TAG = "LiveScroresFragment";

    private Context context;
    private RecyclerView watchListRecyclerView;

    private WatchListAdapter liveScroresListAdapter;
    private ArrayList<WatchListBean> watchlistItems = new ArrayList<>();

    public static MyWatchListFragment getInstance()
    {
        return new MyWatchListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.my_watchlist_fragment_view, container, false);
    }

    @Override
    protected void setUp(View view)
    {
        context = getContext();
        watchListRecyclerView = view.findViewById(R.id.watchlist_recycler_view);
        watchListRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        getLatestData();
        liveScroresListAdapter = new WatchListAdapter(context, watchlistItems);
        watchListRecyclerView.setAdapter(liveScroresListAdapter);
    }


    private void getLatestData()
    {
        String[] types = getResources().getStringArray(R.array.sports_names);
        for(String type: types)
        {
            WatchListBean item = new WatchListBean();
            item.setTeamName(type);

            watchlistItems.add(item);
        }
    }
}

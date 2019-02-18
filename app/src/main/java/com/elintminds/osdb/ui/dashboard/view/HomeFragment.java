package com.elintminds.osdb.ui.dashboard.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseFragment;
import com.elintminds.osdb.ui.dashboard.adapters.HomeListAdapter;
import com.elintminds.osdb.ui.dashboard.adapters.SportsListAdapter;
import com.elintminds.osdb.ui.dashboard.beans.HomeAdapterListBean;
import com.elintminds.osdb.ui.dashboard.beans.SportsAdapterListBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeFragment extends BaseFragment
{
    public static final String TAG = "HomeFragment";

    private Context context;
    private RecyclerView sportsRecyclerView;
    private RecyclerView homeItemsRecyclerView;
    private SportsListAdapter sportsListAdapter;
    private HomeListAdapter homeListAdapter;
    private ArrayList<SportsAdapterListBean> sportsList = new ArrayList<>();
    private ArrayList<HomeAdapterListBean> homeItemsList = new ArrayList<>();

    public static HomeFragment newInstance()
    {
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.home_fragment_view, container, false);
    }

    @Override
    protected void setUp(View view)
    {
        context = getContext();
        sportsRecyclerView = view.findViewById(R.id.sportsList);
        homeItemsRecyclerView = view.findViewById(R.id.homes_items_list);

        getSportsData();
        sportsListAdapter = new SportsListAdapter(context, sportsList);
        sportsRecyclerView.setAdapter(sportsListAdapter);

        getHomeData();
        homeListAdapter = new HomeListAdapter(context, homeItemsList);
        homeItemsRecyclerView.setAdapter(homeListAdapter);
    }

    private void getSportsData()
    {
        String[] list = getResources().getStringArray(R.array.sports_names);
        for(String name: list)
        {
            SportsAdapterListBean item = new SportsAdapterListBean();
            item.setGameName(name);

            sportsList.add(item);
        }
    }

    private void getHomeData()
    {
        String[] types = getResources().getStringArray(R.array.home_item_types);
        for(String type: types)
        {
            HomeAdapterListBean item = new HomeAdapterListBean();
            item.setType(type);

            homeItemsList.add(item);
        }
    }
}

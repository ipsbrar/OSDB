package com.osdb.pro.ui.profile.view;

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
import com.osdb.pro.ui.profile.adapter.FollowingAdapter;
import com.osdb.pro.ui.search_screen.adapters.SearchAdapter;
import com.osdb.pro.ui.search_screen.beans.SearchBean;

import java.util.ArrayList;

public class FollowingFragment extends BaseFragment {

    private FollowingAdapter adapter;
    private RecyclerView followingRecyclerView;
    private ArrayList<SearchBean> dataList = new ArrayList<>();
    private String[] searchSampleData = {"Blackhawks", "Aaron Rodgers", "Australian Open"};

    public static FollowingFragment getInstance() {
        return new FollowingFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.following_fragment_view, container, false);
    }

    @Override
    protected void setUp(View view) {

        followingRecyclerView = view.findViewById(R.id.following_recycler_view);
        followingRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        getSearchData();
        adapter = new FollowingAdapter(getContext(), dataList);
        followingRecyclerView.setAdapter(adapter);
    }

    private void getSearchData() {
        SearchBean itemBean;
        itemBean = new SearchBean();
        itemBean.setSearchType(SearchAdapter.HEADING_TYPE);
        itemBean.setSearchName("Sport");
        dataList.add(itemBean);
        for (String searchItem : searchSampleData) {
            itemBean = new SearchBean();
            itemBean.setSearchType(SearchAdapter.ITEM_TYPE);
            itemBean.setSearchName(searchItem);
            dataList.add(itemBean);
        }
        itemBean = new SearchBean();
        itemBean.setSearchType(SearchAdapter.HEADING_TYPE);
        itemBean.setSearchName("Team");
        dataList.add(itemBean);
        for (String searchItem : searchSampleData) {
            itemBean = new SearchBean();
            itemBean.setSearchType(SearchAdapter.ITEM_TYPE);
            itemBean.setSearchName(searchItem);
            dataList.add(itemBean);
        }
        itemBean = new SearchBean();
        itemBean.setSearchType(SearchAdapter.HEADING_TYPE);
        itemBean.setSearchName("Players");
        dataList.add(itemBean);
        for (String searchItem : searchSampleData) {
            itemBean = new SearchBean();
            itemBean.setSearchType(SearchAdapter.ITEM_TYPE);
            itemBean.setSearchName(searchItem);
            dataList.add(itemBean);
        }
    }

}

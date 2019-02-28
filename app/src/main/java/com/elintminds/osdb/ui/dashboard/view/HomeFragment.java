package com.elintminds.osdb.ui.dashboard.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseFragment;
import com.elintminds.osdb.ui.dashboard.adapters.HomeListAdapter;
import com.elintminds.osdb.ui.dashboard.adapters.SportsListAdapter;
import com.elintminds.osdb.ui.dashboard.beans.HomeAdapterListBean;
import com.elintminds.osdb.ui.dashboard.beans.SportsAdapterListBean;
import com.elintminds.osdb.ui.dashboard.presenter.HomeFragmentPresenterClass;
import com.elintminds.osdb.ui.particular_sport_screen.view.SportsActivity;

import java.util.ArrayList;

public class HomeFragment extends BaseFragment implements DashboardView.SportsAdapterItemClickListener, HomeFragmentView {
    public static final String TAG = "HomeFragment";

    private Context context;
    private ShimmerRecyclerView sportsRecyclerView;
//    private ShimmerRecyclerView homeItemsRecyclerView;
    private SportsListAdapter sportsListAdapter;
//    private HomeListAdapter homeListAdapter;
    private ArrayList<SportsAdapterListBean> sportsList = new ArrayList<>();
//    private ArrayList<HomeAdapterListBean> homeItemsList = new ArrayList<>();
    private HomeFragmentPresenterClass homeFragmentPresenterClass;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment_view, container, false);
    }

    @Override
    protected void setUp(View view) {
        context = getContext();
        sportsRecyclerView = view.findViewById(R.id.sportsList);
        sportsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
//        homeItemsRecyclerView = view.findViewById(R.id.homes_items_list);

        homeFragmentPresenterClass=new HomeFragmentPresenterClass(getActivity(),this);

        homeFragmentPresenterClass.getSportsData();
        homeFragmentPresenterClass.getHomeData();


//        getHomeData();
//        homeListAdapter = new HomeListAdapter(context, homeItemsList);
//        homeItemsRecyclerView.setAdapter(homeListAdapter);
    }

//    private void getSportsData() {
//        String[] list = getResources().getStringArray(R.array.sports_names);
//        int[] imgRes = {R.drawable.nfl, R.drawable.nba, R.drawable.soccer, R.drawable.nhl, R.drawable.golf, R.drawable.tennis, R.drawable.boxing};
//
//        for (int name : imgRes) {
//            SportsAdapterListBean item = new SportsAdapterListBean();
//
//            item.setImgRes(name);
//            sportsList.add(item);
//        }
//    }
//
    /*private void getHomeData() {
        String[] types = getResources().getStringArray(R.array.home_item_types);
        for (String type : types) {
            HomeAdapterListBean item = new HomeAdapterListBean();

            item.setType(type);

            homeItemsList.add(item);
        }
    }*/

    @Override
    public void onSportsIconClick(int position) {
        Intent sportIntent = new Intent(context, SportsActivity.class);
        sportIntent.putExtra("SPORT_ID", position);
        startActivity(sportIntent);
    }

    @Override
    public void getSportsData(ArrayList<SportsAdapterListBean> sportsList) {
        this.sportsList=sportsList;
        sportsListAdapter = new SportsListAdapter(context, sportsList, this);
        sportsRecyclerView.setAdapter(sportsListAdapter);
    }

    @Override
    public void getHomesData(ArrayList<HomeAdapterListBean> homesData) {
//        homeItemsList=homesData;
//        homeListAdapter.notifyDataSetChanged();
    }

    @Override
    public void getError(String error) {

    }

}

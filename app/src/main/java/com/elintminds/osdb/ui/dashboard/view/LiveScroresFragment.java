package com.elintminds.osdb.ui.dashboard.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseFragment;
import com.elintminds.osdb.ui.dashboard.adapters.SportsListAdapter;
import com.elintminds.osdb.ui.dashboard.beans.SportsAdapterListBean;
import com.elintminds.osdb.ui.dashboard.adapters.LiveScroresListAdapter;
import com.elintminds.osdb.ui.dashboard.beans.LiveScroresAdapterBean;
import com.elintminds.osdb.ui.particular_sport_screen.view.SportsActivity;

import java.util.ArrayList;

public class LiveScroresFragment extends BaseFragment implements DashboardView.SportsAdapterItemClickListener {

    public static final String TAG = "LiveScroresFragment";

    private Context context;
    private RecyclerView sportsRecyclerView;
    private RecyclerView latestItemsRecyclerView;
    private SportsListAdapter sportsListAdapter;
    private LiveScroresListAdapter liveScroresListAdapter;
    private ArrayList<SportsAdapterListBean> sportsList = new ArrayList<>();
    private ArrayList<LiveScroresAdapterBean> latestItemsList = new ArrayList<>();

    public static LiveScroresFragment newInstance()
    {
        return new LiveScroresFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.live_scores_fragment_view, container, false);
    }

    @Override
    protected void setUp(View view)
    {
        context = getContext();
        sportsRecyclerView = view.findViewById(R.id.sportsList);
        latestItemsRecyclerView = view.findViewById(R.id.latest_items_list);

        getSportsData();
        sportsListAdapter = new SportsListAdapter(context, sportsList, this);
        sportsRecyclerView.setAdapter(sportsListAdapter);

        getLatestData();


        liveScroresListAdapter = new LiveScroresListAdapter(context, latestItemsList);
        latestItemsRecyclerView.setAdapter(liveScroresListAdapter);
    }

    private void getSportsData()
    {
        String[] list = getResources().getStringArray(R.array.sports_names);
        int[] imgRes = {R.drawable.nfl, R.drawable.nba, R.drawable.soccer, R.drawable.nhl, R.drawable.golf, R.drawable.tennis, R.drawable.boxing};
        for (int name : imgRes) {
            SportsAdapterListBean item = new SportsAdapterListBean();

//            item.setImgRes(name);
            sportsList.add(item);
        }
    }

    private void getLatestData()
    {
        int[] types = getResources().getIntArray(R.array.live_item_types);
        for(int type: types)
        {
            LiveScroresAdapterBean item = new LiveScroresAdapterBean();
            item.setType(type);

            latestItemsList.add(item);
        }
    }

    @Override
    public void onSportsIconClick(int position)
    {
        Intent sportIntent = new Intent(context, SportsActivity.class);
        sportIntent.putExtra("SPORT_ID",position);
        startActivity(sportIntent);
    }
}

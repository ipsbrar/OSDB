package com.osdb.app.ui.dashboard.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
import com.osdb.app.R;
import com.osdb.app.ui.base.view.BaseFragment;
import com.osdb.app.ui.dashboard.adapters.SportsListAdapter;
import com.osdb.app.ui.dashboard.beans.SportsAdapterListBean;
import com.osdb.app.ui.dashboard.adapters.LiveScroresListAdapter;
import com.osdb.app.ui.dashboard.beans.LiveScroresAdapterBean;
import com.osdb.app.ui.dashboard.presenter.LiveScroresPresenterClass;

import java.util.ArrayList;

public class LiveScroresFragment extends BaseFragment implements DashboardView.SportsAdapterItemClickListener, LiveScroresView {

    public static final String TAG = "LiveScroresFragment";

    private Context context;
    private ShimmerRecyclerView sportsRecyclerView;
    private RecyclerView latestItemsRecyclerView;
    private SportsListAdapter sportsListAdapter;
    private LiveScroresListAdapter liveScroresListAdapter;
    private ArrayList<SportsAdapterListBean> sportsList = new ArrayList<>();
    private ArrayList<LiveScroresAdapterBean> latestItemsList = new ArrayList<>();
    private LiveScroresPresenterClass liveScroresPresenterClass;

    public static LiveScroresFragment newInstance() {
        return new LiveScroresFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.live_scores_fragment_view, container, false);
    }

    @Override
    protected void setUp(View view) {
        context = getContext();

        sportsRecyclerView = view.findViewById(R.id.sportsList);
        sportsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        sportsListAdapter = new SportsListAdapter(context, sportsList, this);
        sportsRecyclerView.setAdapter(sportsListAdapter);
        sportsRecyclerView.showShimmerAdapter();

        latestItemsRecyclerView = view.findViewById(R.id.latest_items_list);
        liveScroresPresenterClass = new LiveScroresPresenterClass(getActivity(), this);
        liveScroresPresenterClass.getSportsData();
        getLatestData();
        liveScroresListAdapter = new LiveScroresListAdapter(context, latestItemsList);
        latestItemsRecyclerView.setAdapter(liveScroresListAdapter);
    }

    private void getSportsData() {
        String[] list = getResources().getStringArray(R.array.sports_names);
        int[] imgRes = {R.drawable.nfl, R.drawable.nba, R.drawable.soccer, R.drawable.nhl, R.drawable.golf, R.drawable.tennis, R.drawable.boxing};
        for (int name : imgRes) {
            SportsAdapterListBean item = new SportsAdapterListBean();

//            item.setImgRes(name);
            sportsList.add(item);
        }
    }

    private void getLatestData() {
        int[] types = getResources().getIntArray(R.array.live_item_types);
        for (int type : types) {
            LiveScroresAdapterBean item = new LiveScroresAdapterBean();
            item.setType(type);

            latestItemsList.add(item);
        }
    }

    @Override
    public void onSportsIconClick(int position, String name) {
//        Intent sportIntent = new Intent(context, SportsActivity.class);
//        sportIntent.putExtra("SPORT_ID", position);
//        startActivity(sportIntent);
    }

    @Override
    public void getSportsData(ArrayList<SportsAdapterListBean> sportsList) {
        this.sportsList = sportsList;
        sportsListAdapter.setDataList(this.sportsList);
        sportsRecyclerView.hideShimmerAdapter();

    }

    @Override
    public void getError(String error) {

    }
}

package com.elintminds.osdb.ui.team_details_screen.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseFragment;
import com.elintminds.osdb.ui.player_details_screen.view.PlayerDetailsActivity;
import com.elintminds.osdb.ui.search_finding_screen.adapters.PlayerProfileAdapter;
import com.elintminds.osdb.ui.search_finding_screen.beans.PlayersProfileBean;
import com.elintminds.osdb.ui.search_finding_screen.view.PlayerFragment;
import com.elintminds.osdb.ui.team_details_screen.adapters.StatsBeans;
import com.elintminds.osdb.ui.team_details_screen.adapters.StatsMainAdapter;
import com.elintminds.osdb.ui.team_details_screen.beans.StatsHorizontalBean;
import com.elintminds.osdb.ui.team_details_screen.beans.StatsMainBean;
import com.elintminds.osdb.ui.team_details_screen.beans.StatsVerticalBean;
import com.elintminds.osdb.ui.team_details_screen.presenter.StatsPresenterClass;

import java.util.ArrayList;
import java.util.List;

public class StatsFragment extends BaseFragment implements StatsView {
    public static final String TAG = "StatsFragment";
    private static int ROW_SIZE = 15;
    private static int COLUMN_SIZE = 15;
    //no  data found
    private ConstraintLayout no_data;
    private TextView txt_no_data_title, txt_no_data_disp;
    private Context context;
    private RecyclerView statsRV;
    private StatsMainAdapter statsMainAdapter;
    private ArrayList<StatsBeans.InnerStatsBean> arrayList = new ArrayList<>();
    private ArrayList<List<String>> stringArrayList = new ArrayList<>();
    private SwipeRefreshLayout swipe_refresh;
    private StatsPresenterClass statsPresenterClass;

    public static StatsFragment getInstance(ArrayList<StatsBeans> arrayListStats, String id) {
        StatsFragment statsFragment = new StatsFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("STATS_DATA", arrayListStats);
        bundle.putString("team_id", id);
        statsFragment.setArguments(bundle);
        return statsFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e("CheckStatusStats", "  OnCreateView");
        return inflater.inflate(R.layout.single_recycler_view, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (isVisible())
            Log.e("CheckStatusStats", "  OnActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        if (isVisible())
            Log.e("CheckStatusStats", "  OnStart");
    }

    @Override
    protected void setUp(View view) {
        context = getContext();
        //        No data found Views
        txt_no_data_title = view.findViewById(R.id.txt_no_data_title);
        txt_no_data_disp = view.findViewById(R.id.txt_no_data_disp);
        no_data = view.findViewById(R.id.no_data);
        txt_no_data_title.setText(getString(R.string.no_data_found));
        txt_no_data_disp.setText(getString(R.string.please_try_again));
        no_data.setVisibility(View.GONE);

        statsRV = view.findViewById(R.id.recycler_view);
        swipe_refresh = view.findViewById(R.id.swipe_refresh);
        swipe_refresh.setRefreshing(false);
        swipe_refresh.setEnabled(false);

        statsRV.setLayoutManager(new LinearLayoutManager(context) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        statsPresenterClass = new StatsPresenterClass(getActivity(), this);
        Bundle bundle = getArguments();
        if (bundle != null) {
            ArrayList<StatsBeans> statsBeansArrayList = (ArrayList<StatsBeans>) bundle.getSerializable("STATS_DATA");
            String teamId = bundle.getString("team_id");
            if (statsBeansArrayList != null && statsBeansArrayList.size() > 0) {
                arrayList = statsBeansArrayList.get(0).getInnerStatsBeansList();
            } else if (teamId != null && !TextUtils.isEmpty(teamId)) {
                statsPresenterClass.fetchTeamStatsData(teamId);
            }
        }

        setupRecyclerView();

        swipe_refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipe_refresh.setRefreshing(false);
            }
        });
    }


    private void setupRecyclerView() {
        statsMainAdapter = new StatsMainAdapter(getActivity(), arrayList);
        statsRV.setAdapter(statsMainAdapter);
    }

    @Override
    public void success(ArrayList<StatsBeans> statsData) {
        if (statsData != null && statsData.size() > 0) {
            if (statsMainAdapter == null) {
                statsMainAdapter = new StatsMainAdapter(getActivity(), arrayList);
                statsRV.setAdapter(statsMainAdapter);
            } else {
                arrayList = statsData.get(0).getInnerStatsBeansList();
                statsMainAdapter.setData(arrayList);
            }
            statsRV.setVisibility(View.VISIBLE);
            no_data.setVisibility(View.GONE);
        } else {
            statsRV.setVisibility(View.GONE);
            no_data.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void error(String error) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show();
        statsRV.setVisibility(View.GONE);
        no_data.setVisibility(View.VISIBLE);
    }
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.e("CheckStatusStats","ISVisiBle");
    }
}

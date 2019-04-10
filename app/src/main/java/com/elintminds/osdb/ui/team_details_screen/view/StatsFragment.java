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
import android.widget.*;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.DemoTable.Cell;
import com.elintminds.osdb.ui.DemoTable.ColumnHeader;
import com.elintminds.osdb.ui.DemoTable.MyTableViewAdapter;
import com.elintminds.osdb.ui.DemoTable.RowHeader;
import com.elintminds.osdb.ui.base.view.BaseFragment;
import com.elintminds.osdb.ui.team_details_screen.beans.StatsBeanVertical;
import com.elintminds.osdb.ui.team_details_screen.beans.StatsBeans;
import com.elintminds.osdb.ui.team_details_screen.adapters.StatsMainAdapter;
import com.elintminds.osdb.ui.team_details_screen.presenter.StatsPresenterClass;
import com.evrencoskun.tableview.TableView;

import java.util.ArrayList;
import java.util.List;

public class StatsFragment extends BaseFragment implements StatsView {
    public static final String TAG = "StatsFragment";
    //no  data found
    private ConstraintLayout no_data;
    private TextView txt_no_data_title, txt_no_data_disp;

    private LinearLayout ll_table_main;
    private ScrollView sv_stats;
    private StatsPresenterClass statsPresenterClass;

    public static StatsFragment getInstance(ArrayList<StatsBeanVertical> arrayListStats, String id) {
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
        return inflater.inflate(R.layout.activity_stats, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    protected void setUp(View view) {
//        context = getContext();
        ll_table_main = view.findViewById(R.id.ll_table_main);
        sv_stats = view.findViewById(R.id.sv_stats);
        //        No data found Views
        txt_no_data_title = view.findViewById(R.id.txt_no_data_title);
        txt_no_data_disp = view.findViewById(R.id.txt_no_data_disp);
        no_data = view.findViewById(R.id.no_data);
        txt_no_data_title.setText(getString(R.string.no_data_found));
        txt_no_data_disp.setText(getString(R.string.please_try_again));
        no_data.setVisibility(View.GONE);

        statsPresenterClass = new StatsPresenterClass(getActivity(), this);
        Bundle bundle = getArguments();
        if (bundle != null) {
            ArrayList<StatsBeanVertical> statsBeansArrayList = (ArrayList<StatsBeanVertical>) bundle.getSerializable("STATS_DATA");
            String teamId = bundle.getString("team_id");
            if (statsBeansArrayList != null && statsBeansArrayList.size() > 0) {
                showProgressDialog();
                setUpStatsLayout(statsBeansArrayList);
            } else if (teamId != null && !TextUtils.isEmpty(teamId)) {
                statsPresenterClass.fetchTeamStatsData(teamId);
            }
        }

    }

    @Override
    public void success(List<ColumnHeader> columnHeaderList, List<RowHeader> rowHeaderList, List<List<Cell>> cellList) {


    }

    @Override
    public void success(ArrayList<StatsBeanVertical> verticalArrayList) {
        showProgressDialog();
        setUpStatsLayout(verticalArrayList);
    }

    @Override
    public void error(String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
        sv_stats.setVisibility(View.GONE);
        no_data.setVisibility(View.VISIBLE);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.e("CheckStatusStats", "ISVisiBle");
    }

    private void setUpStatsLayout(ArrayList<StatsBeanVertical> verticalArrayList) {
        long startTime = System.currentTimeMillis();
        if (verticalArrayList.size() > 0) {
            for (int i = 0; i < verticalArrayList.size(); i++) {
                View pollOptionView = LayoutInflater.from(getActivity()).inflate(R.layout.table_layout, null);
                ll_table_main.addView(pollOptionView);
                TextView txt_main_header = pollOptionView.findViewById(R.id.txt_main_header);
                TextView txt_header = pollOptionView.findViewById(R.id.txt_header);
                TableView content_container = pollOptionView.findViewById(R.id.content_container);
                txt_main_header.setText(verticalArrayList.get(i).getMainHeader());
                txt_header.setText(verticalArrayList.get(i).getHeader());

                MyTableViewAdapter adapter = new MyTableViewAdapter(getActivity());
                content_container.setAdapter(adapter);
                adapter.setAllItems(verticalArrayList.get(i).getTableList().getColumnHeaderList()
                        , verticalArrayList.get(i).getTableList().getRowHeaderList()
                        , verticalArrayList.get(i).getTableList().getCellList());
            }
        }
        hideProgressDialog();
        long stopTime = System.currentTimeMillis();
        Log.e("TimeInStats" , "time calculation   "+   (stopTime-startTime));
    }
}

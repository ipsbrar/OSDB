package com.osdb.app.ui.search_finding_screen.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.osdb.app.R;
import com.osdb.app.ui.base.view.BaseFragment;
import com.osdb.app.ui.search_finding_screen.adapters.SchedulesAdapter;
import com.osdb.app.ui.search_finding_screen.beans.ScheduleBean;
import com.osdb.app.ui.search_finding_screen.presenter.ScheduleFragmentPresenterClass;

import java.util.ArrayList;
import java.util.Calendar;

public class ScheduleFragment extends BaseFragment implements ScheduleFragmentView {
    public static final String TAG = "ScheduleFragment";


    //    No data found layout
    private ConstraintLayout no_data;
    private TextView txt_no_data_title, txt_no_data_disp;

    private SwipeRefreshLayout swipeRefreshLayout;

    private Context context;
    private RecyclerView scheduleRV;
    private SchedulesAdapter adapter;
    private ArrayList<ScheduleBean> dataList = new ArrayList<>();
    private ScheduleFragmentPresenterClass scheduleFragmentPresenterClass;
    private String slug, year, session;

    public static ScheduleFragment getInstance(Bundle args) {
        ScheduleFragment fragment = new ScheduleFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
//        scheduleCount = getArguments().getInt("SCHEDULES");


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.single_recycler_view_2, container, false);


        return view;
    }


    @Override
    protected void setUp(View view) {

        //        No data found Views
        txt_no_data_title = view.findViewById(R.id.txt_no_data_title);
        txt_no_data_disp = view.findViewById(R.id.txt_no_data_disp);
        no_data = view.findViewById(R.id.no_data);
        txt_no_data_title.setText(getString(R.string.no_data_found));
        txt_no_data_disp.setText(getString(R.string.please_try_again));
        no_data.setVisibility(View.GONE);

        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh);


        context = getContext();
        scheduleRV = view.findViewById(R.id.recycler_view);


        scheduleFragmentPresenterClass = new ScheduleFragmentPresenterClass(getActivity(), this);


        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                no_data.setVisibility(View.GONE);
                scheduleRV.setVisibility(View.VISIBLE);
                session = getAppPreferenceHelperClass().getSeason().equalsIgnoreCase("")
                        ? getAppPreferenceHelperClass().getSeason()
                        : "PRE";
                year = getAppPreferenceHelperClass().getSeason().equalsIgnoreCase("")
                        ? getAppPreferenceHelperClass().getYear()
                        : String.valueOf(Calendar.getInstance().get(Calendar.YEAR));

                scheduleFragmentPresenterClass.getSlugName(slug != null ? slug : "NFL", year, session);

            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        session = !getAppPreferenceHelperClass().getSeason().equalsIgnoreCase("")
                ? getAppPreferenceHelperClass().getSeason()
                : "PRE";
        year = !getAppPreferenceHelperClass().getSeason().equalsIgnoreCase("")
                ? getAppPreferenceHelperClass().getYear()
                : String.valueOf(Calendar.getInstance().get(Calendar.YEAR));

        if (getArguments() != null) {
            slug = getArguments().getString("SLUG");
            scheduleFragmentPresenterClass.getSlugName(slug != null ? slug : "NFL", year, session);
        }
    }

    @Override
    public void success(ArrayList<ScheduleBean> scheduleBeanArrayList) {
        if (scheduleBeanArrayList.size() > 0) {
            this.dataList = scheduleBeanArrayList;
//        adapter.setDataList(this.dataList);
            adapter = new SchedulesAdapter(context, this.dataList);
            scheduleRV.setAdapter(adapter);
            no_data.setVisibility(View.GONE);
            scheduleRV.setVisibility(View.VISIBLE);
        } else {
            no_data.setVisibility(View.VISIBLE);
            scheduleRV.setVisibility(View.GONE);
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void error(String error) {
        no_data.setVisibility(View.VISIBLE);
        scheduleRV.setVisibility(View.GONE);
        Toast.makeText(context, "" + error, Toast.LENGTH_SHORT).show();
        swipeRefreshLayout.setRefreshing(false);
    }
//
//    @Override
//    public void fetchTeamsData(String sportsName) {
//        scheduleFragmentPresenterClass.getSlugName(sportsName != null ? sportsName : "NFL");
//    }
}

package com.elintminds.osdb.ui.dashboard.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseFragment;
import com.elintminds.osdb.ui.dashboard.adapters.PollAdapter;
import com.elintminds.osdb.ui.dashboard.beans.PollAdapterBean;
import com.elintminds.osdb.ui.dashboard.presenter.PollsPresenterClass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class PollFragment extends BaseFragment implements DashboardView.PollOptionListner, PollView, DashboardActivity.OnDateClick {

    public static final String TAG = "PollFragment";

    //    No data found layout
    private ConstraintLayout no_data;
    private TextView txt_no_data_title, txt_no_data_disp;

    private SwipeRefreshLayout swipeRefreshLayout;
    private Context context;
    private ShimmerRecyclerView pollRecyclerView;
    private PollAdapter pollAdapter;
    public static TextView dateTxt;
    private ArrayList<PollAdapterBean> pollList = new ArrayList<>();
    private PollsPresenterClass<PollFragment, com.elintminds.osdb.ui.dashboard.model.PollsInteractor> pollsPresenterClass;
    private String currentDate;
    private String userID;

    public static PollFragment newInstance() {
        return new PollFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.poll_fragment_view, container, false);
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

        context = getContext();
        pollsPresenterClass = new PollsPresenterClass<PollFragment, com.elintminds.osdb.ui.dashboard.model.PollsInteractor>(context, this);
        pollRecyclerView = view.findViewById(R.id.poll_recycler_view);
        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh);
        dateTxt = view.findViewById(R.id.date_txt);
        LinearLayoutManager llm = new LinearLayoutManager(context);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        pollRecyclerView.setLayoutManager(llm);
        userID = getAppPreferenceHelperClass().getUserId();
        currentDate = getCurrentDate();
        Log.e("CurrentDatePolls", currentDate);
        pollsPresenterClass.getPollsData(currentDate != null ? currentDate : "2019-02-23",
                userID != null ? userID : "199");

//        pollsPresenterClass.getPollsData(AppConstants.getCurrentDate(), "2");
        pollAdapter = new PollAdapter(context, pollList, this);
        pollRecyclerView.setAdapter(pollAdapter);
        pollRecyclerView.showShimmerAdapter();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                pollRecyclerView.setVisibility(View.VISIBLE);
                no_data.setVisibility(View.GONE);
                pollsPresenterClass.getPollsData(currentDate != null ? currentDate : "2019-02-23",
                        userID != null ? userID : "199");
                pollRecyclerView.showShimmerAdapter();
            }
        });
        DashboardActivity dashboardActivity = new DashboardActivity();
        dashboardActivity.setOnDateClick(this);
    }


    @Override
    public void onOptionClick(int pollId, int optionId) {
        String defaultToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczpcL1wvc3RhZ2luZy5vc2RiLnBybzo4MVwvYXBpXC92MVwvbG9naW4iLCJpYXQiOjE1NTIzNzA2OTYsImV4cCI6MTU1MjgwMjY5NiwibmJmIjoxNTUyMzcwNjk2LCJqdGkiOiJERUpQVTN2cnZBZEIyQzZrIiwic3ViIjozNjIsInBydiI6Ijg3ZTBhZjFlZjlmZDE1ODEyZmRlYzk3MTUzYTE0ZTBiMDQ3NTQ2YWEifQ.IrSsXMjW-BWKhrfFuEMCiitdVS_ijN6bFBvfsE2_Cjk";
        String token = getAppPreferenceHelperClass().getToken() != null ? getAppPreferenceHelperClass().getToken() : defaultToken;
        pollsPresenterClass.VotePolls(getActivity(), String.valueOf(pollId), String.valueOf(optionId), token);
//        pollList.get(listPosition).setVisible(true);
//        pollAdapter.notifyDataSetChanged();

    }

    @Override
    public void getPollData(ArrayList<PollAdapterBean> arrayList) {
        if (arrayList.size() > 0) {
            pollAdapter.setDataList(arrayList);
        } else {
            pollRecyclerView.setVisibility(View.GONE);
            no_data.setVisibility(View.VISIBLE);
        }
        pollRecyclerView.hideShimmerAdapter();
        swipeRefreshLayout.setRefreshing(false);

    }

    @Override
    public void VotePolls(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void error(String error, boolean isVisible) {

        if (isVisible) {
            pollRecyclerView.setVisibility(View.GONE);
            no_data.setVisibility(View.VISIBLE);
            pollRecyclerView.hideShimmerAdapter();
            swipeRefreshLayout.setRefreshing(false);
        }
        Toast.makeText(context, "" + error, Toast.LENGTH_SHORT).show();

    }

    // get Current date
    private String getCurrentDate() {
        SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String date;

        Date currDate = Calendar.getInstance().getTime();
        date = spf.format(currDate);

        Log.e("Date", "" + date);

        return date;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    @Override
    public void dateClickPoll(String date) {
        Toast.makeText(getActivity(), "fragment Toast working", Toast.LENGTH_SHORT).show();
        currentDate = date;
        pollsPresenterClass.getPollsData(currentDate != null ? currentDate : "2019-02-23",
                userID != null ? userID : "199");
        pollRecyclerView.showShimmerAdapter();
        pollList = null;
    }
}

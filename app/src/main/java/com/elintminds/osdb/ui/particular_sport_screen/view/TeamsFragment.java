package com.elintminds.osdb.ui.particular_sport_screen.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseFragment;
import com.elintminds.osdb.ui.particular_sport_screen.adapters.TeamsViewAdapter;
import com.elintminds.osdb.ui.particular_sport_screen.beans.TeamClubBean;
import com.elintminds.osdb.ui.particular_sport_screen.beans.TeamsBean;
import com.elintminds.osdb.ui.particular_sport_screen.presenter.TeamFragmentPresenter;
import com.elintminds.osdb.ui.particular_sport_screen.presenter.TeamFragmentPresenterClass;
import com.elintminds.osdb.ui.team_details_screen.view.TeamDetailsActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TeamsFragment extends BaseFragment implements SportScreenView.TeamsExpandableItemsListener, TeamFragmentView, SportsActivity.TeamFragData {
    public static final String TAG = "TeamsFragment";

    //    No data found layout
    private ConstraintLayout no_data;
    private TextView txt_no_data_title, txt_no_data_disp;

    private SwipeRefreshLayout swipeRefreshLayout;
    private Context context;
    private ExpandableListView teamsEpView;
    private TeamsViewAdapter adapter;
    private ArrayList<TeamClubBean> dataList = new ArrayList<>();
    private TeamFragmentPresenterClass teamFragmentPresenter;

    private String[] clubNames = {"AFC West", "NFC North", "AFC North"};
    private String[][] teamsNames = {
            {"San Francisco", "Arizona", "Seattle Seahawks", "Los Angeles Rams"},
            {"Chicago Bears", "Detroit Lions", "Green Bay Packers", "Minnesota Vikings"},
            {"Baltimore Ravens", "Cincinnati Bengals", "Cleveland Browns"}
    };
    private boolean[][] isTeamFollowed = {
            {true, false, false, false},
            {true, false, false, false},
            {true, false, false}
    };

    private String SportsName;

    public static TeamsFragment getInstance(String sportsName) {
        TeamsFragment teamsFragment = new TeamsFragment();
        Bundle bundle = new Bundle();
        bundle.putString("SPORTS_NAME", sportsName);
        teamsFragment.setArguments(bundle);
        return teamsFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.teams_fragment_view, container, false);
    }


    @Override
    protected void setUp(View view) {
        context = getContext();
        teamsEpView = view.findViewById(R.id.teams_expandable_view);
        teamsEpView.setVisibility(View.VISIBLE);
//        No data found Views
        txt_no_data_title = view.findViewById(R.id.txt_no_data_title);
        txt_no_data_disp = view.findViewById(R.id.txt_no_data_disp);
        no_data = view.findViewById(R.id.no_data);
        txt_no_data_title.setText(getString(R.string.no_data_found));
        txt_no_data_disp.setText(getString(R.string.please_try_again));
        no_data.setVisibility(View.GONE);

        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh);
        teamFragmentPresenter = new TeamFragmentPresenterClass(getActivity(), this);
        Bundle bundle = getArguments();
        SportsActivity sportsActivity = new SportsActivity();
        sportsActivity.setTeamInterFace(this);

        if (bundle != null) {
            SportsName = bundle.getString("SPORTS_NAME");
            teamFragmentPresenter.getSlugName(SportsName != null ? SportsName : "NFL");
        }

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                no_data.setVisibility(View.GONE);
                teamsEpView.setVisibility(View.VISIBLE);
                teamFragmentPresenter.getSlugName(SportsName != null ? SportsName : "NFL");
            }
        });

    }

    @Override
    public void onTeamClick(int groupPos, int childPos) {
        String teamName = dataList.get(groupPos).getTeamsList().get(childPos).getTeamName();
        String divisionName = SportsName;
        String teamID = String.valueOf(dataList.get(groupPos).getTeamsList().get(childPos).getId());
        String imgUrl = String.valueOf(dataList.get(groupPos).getTeamsList().get(childPos).getLogo());
        String imgPic = null;
        if (!imgUrl.equalsIgnoreCase("")) {
            try {
                JSONArray jsonArray = new JSONArray(imgUrl);
                JSONObject jsonObject = jsonArray.getJSONObject(0);
                imgPic = "https://s3-us-west-2.amazonaws.com/osdb/" + jsonObject.getString("href");
                Log.e("MYIMAGEURL", imgPic);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        Intent intent = new Intent(context, TeamDetailsActivity.class);
        intent.putExtra("TEAM_NAME", teamName);
        intent.putExtra("DIVISION_NAME", divisionName);
        intent.putExtra("TEAM_ID", teamID);
        intent.putExtra("PROFILE_PIC", imgPic);
        startActivity(intent);
    }

    @Override
    public void getAllListsOfTeam(ArrayList<TeamClubBean> teamClubBean) {
        if (teamClubBean != null && teamClubBean.size() > 0) {
            this.dataList = teamClubBean;
            adapter = new TeamsViewAdapter(context, this.dataList, this);
            teamsEpView.setAdapter(adapter);

//            adapter.notifyDataSetChanged();
        } else {
            no_data.setVisibility(View.VISIBLE);
            teamsEpView.setVisibility(View.GONE);
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void getError(String error) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show();
        no_data.setVisibility(View.VISIBLE);
        teamsEpView.setVisibility(View.GONE);
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void fetchTeamsData(String sportsName) {
        teamsEpView.setVisibility(View.VISIBLE);
        no_data.setVisibility(View.GONE);
        teamFragmentPresenter.getSlugName(sportsName != null ? sportsName : "NFL");
        swipeRefreshLayout.setRefreshing(false);
    }
}

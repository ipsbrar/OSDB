package com.elintminds.osdb.ui.particular_sport_screen.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseFragment;
import com.elintminds.osdb.ui.particular_sport_screen.adapters.TeamsViewAdapter;
import com.elintminds.osdb.ui.particular_sport_screen.beans.TeamClubBean;
import com.elintminds.osdb.ui.particular_sport_screen.beans.TeamsBean;
import com.elintminds.osdb.ui.particular_sport_screen.presenter.TeamFragmentPresenter;
import com.elintminds.osdb.ui.particular_sport_screen.presenter.TeamFragmentPresenterClass;
import com.elintminds.osdb.ui.team_details_screen.view.TeamDetailsActivity;

import java.util.ArrayList;

public class TeamsFragment extends BaseFragment implements SportScreenView.TeamsExpandableItemsListener, TeamFragmentView {
    public static final String TAG = "TeamsFragment";

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

    private  String SportsName;

    public static TeamsFragment getInstance(String sportsName) {
        TeamsFragment teamsFragment=new TeamsFragment();
        Bundle bundle = new Bundle();
        bundle.putString("SPORTS_NAME",sportsName);
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
        teamFragmentPresenter = new TeamFragmentPresenterClass(getActivity(), this);
        Bundle bundle = getArguments();

        if (bundle != null){
          SportsName=  bundle.getString("SPORTS_NAME");
            teamFragmentPresenter.getSlugName(SportsName != null ? SportsName : "NFL");
        }

    }

    @Override
    public void onTeamClick(int groupPos, int childPos) {
        String teamName = dataList.get(groupPos).getTeamsList().get(childPos).getTeamName();
        String divisionName=dataList.get(groupPos).getTeamClubName();
        String teamID = String.valueOf(dataList.get(groupPos).getTeamsList().get(childPos).getId());
        Intent intent = new Intent(context, TeamDetailsActivity.class);
        intent.putExtra("TEAM_NAME", teamName);
        intent.putExtra("DIVISION_NAME", divisionName);
        intent.putExtra("TEAM_ID", teamID);
        startActivity(intent);
    }

    @Override
    public void getAllListsOfTeam(ArrayList<TeamClubBean> teamClubBean) {
        if (teamClubBean.size() > 0) {
            this.dataList = teamClubBean;
            adapter = new TeamsViewAdapter(context, this.dataList, this);
            teamsEpView.setAdapter(adapter);
//            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void getError(String error) {

    }
}

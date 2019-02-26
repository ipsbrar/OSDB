package com.elintminds.osdb.ui.particular_sport_screen.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseFragment;
import com.elintminds.osdb.ui.particular_sport_screen.adapters.TeamsViewAdapter;
import com.elintminds.osdb.ui.particular_sport_screen.beans.TeamClubBean;
import com.elintminds.osdb.ui.particular_sport_screen.beans.TeamsBean;

import java.util.ArrayList;

public class TeamsFragment extends BaseFragment
{
    public static final String TAG = "TeamsFragment";

    private Context context;
    private ExpandableListView teamsEpView;
    private TeamsViewAdapter adapter;
    private ArrayList<TeamClubBean> dataList = new ArrayList<>();

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

    public static TeamsFragment getInstance()
    {
        return new TeamsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.teams_fragment_view, container, false);
    }


    @Override
    protected void setUp(View view)
    {
        context = getContext();
        teamsEpView = view.findViewById(R.id.teams_expandable_view);

        setupExpandableView();
    }

    private void setupExpandableView()
    {
        getSampleData();
        adapter = new TeamsViewAdapter(context, dataList);
        teamsEpView.setAdapter(adapter);
    }

    private void getSampleData()
    {
        for (int i=0; i<clubNames.length; i++)
        {
            TeamClubBean clubBean = new TeamClubBean();
            clubBean.setTeamClubName(clubNames[i]);
            ArrayList<TeamsBean> teamsList = new ArrayList<>();
            for(int j=0; j<teamsNames[i].length; j++)
            {
                TeamsBean teamsBean = new TeamsBean();
                teamsBean.setTeamName(teamsNames[i][j]);
                teamsBean.setFollowing(isTeamFollowed[i][j]);

                teamsList.add(teamsBean);
            }
            clubBean.setTeamsList(teamsList);

            dataList.add(clubBean);
        }
    }
}

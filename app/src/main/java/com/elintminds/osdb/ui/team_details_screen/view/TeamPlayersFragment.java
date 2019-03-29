package com.elintminds.osdb.ui.team_details_screen.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseFragment;
import com.elintminds.osdb.ui.player_details_screen.view.PlayerDetailsActivity;
import com.elintminds.osdb.ui.team_details_screen.adapters.TeamPlayersAdapter;
import com.elintminds.osdb.ui.team_details_screen.beans.TeamPlayersBean;
import com.elintminds.osdb.ui.team_details_screen.presenter.TeamDetailsPresenterClass;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TeamPlayersFragment extends BaseFragment implements TeamDetailsView.TeamPlayersAdapterListener, TeamDetailsView.TeamPlayersView {
    public static final String TAG = "TeamPlayersFragment";

    private Context context;
    private RecyclerView statsRV;
    private TeamPlayersAdapter adapter;
    private ArrayList<TeamPlayersBean.Player> dataList = new ArrayList<>();
    private String[] samplePlayerNames = {"Davante Adams", "Aaron Rodgers", "JK Scott", "Jaire Alexander"
            , "David Bakhtiari", "Evan Baylis", "Kapri Bibbs", "Tim Boyle"};
    private TeamDetailsPresenterClass teamDetailsPresenterClass;

    private String teamName, divisionName, teamID;

    public static TeamPlayersFragment getInstance(String teamName, String divisionName, String teamId) {
        TeamPlayersFragment teamPlayersFragment = new TeamPlayersFragment();
        Bundle bundle = new Bundle();
        bundle.putString("TEAM_NAME", teamName);
        bundle.putString("DIVISION_NAME", divisionName);
        bundle.putString("TEAM_ID", teamId);
        teamPlayersFragment.setArguments(bundle);
        return teamPlayersFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.single_recycler_view, container, false);
    }


    @Override
    protected void setUp(View view) {
        context = getContext();
        statsRV = view.findViewById(R.id.recycler_view);
        statsRV.setPadding(0, 10, 0, 2);

        teamDetailsPresenterClass = new TeamDetailsPresenterClass(getActivity(), this);
        Bundle bundle = getArguments();
        if (bundle != null) {
            teamName = bundle.getString("TEAM_NAME");
            divisionName = bundle.getString("DIVISION_NAME");
            teamID = bundle.getString("TEAM_ID");

            teamDetailsPresenterClass.getTeamID(teamID != null ? teamID : "33");
        }

    }


    @Override
    public void onPlayerItemClick(int position) {
        Intent intent = new Intent(context, PlayerDetailsActivity.class);
        intent.putExtra("AGE", dataList.get(position).getDateOfBirth());
        intent.putExtra("PLAYER_NAME", dataList.get(position).getFullName());
        intent.putExtra("TEAM_NAME", teamName);
        intent.putExtra("DIVISION_NAME", divisionName);
        String imgPic = null;
        if (!dataList.get(position).getHeadshots().equalsIgnoreCase("")) {
            try {
                JSONArray jsonArray = new JSONArray(dataList.get(position).getHeadshots());
                JSONObject jsonObject = jsonArray.getJSONObject(0);
                imgPic = "https://s3-us-west-2.amazonaws.com/osdb/" + jsonObject.getString("href");
                Log.e("MYIMAGEURL", imgPic);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        intent.putExtra("PROFILE_PIC", imgPic);
        intent.putExtra("PLAYER_ID", String.valueOf(dataList.get(position).getId()));
        startActivity(intent);
    }

    @Override
    public void getPlayers(TeamPlayersBean teamPlayersBean) {
//        adapter.setDataList(teamPlayersBean.getPlayers());
        this.dataList = teamPlayersBean.getPlayers();
        adapter = new TeamPlayersAdapter(context, this.dataList, this);
        statsRV.setAdapter(adapter);
    }

    @Override
    public void getError(String error) {

    }
}

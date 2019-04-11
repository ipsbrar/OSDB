package com.osdb.android.ui.team_details_screen.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.osdb.android.R;
import com.osdb.android.ui.base.view.BaseFragment;
import com.osdb.android.ui.player_details_screen.view.PlayerDetailsActivity;
import com.osdb.android.ui.team_details_screen.adapters.TeamPlayersAdapter;
import com.osdb.android.ui.team_details_screen.beans.TeamPlayersBean;
import com.osdb.android.ui.team_details_screen.presenter.TeamDetailsPresenterClass;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TeamPlayersFragment extends BaseFragment implements TeamDetailsView.TeamPlayersAdapterListener, TeamDetailsView.TeamPlayersView {
    public static final String TAG = "TeamPlayersFragment";

    //no  data found
    private ConstraintLayout no_data;
    private TextView txt_no_data_title, txt_no_data_disp;

    private Context context;
    private RecyclerView statsRV;
    private TeamPlayersAdapter adapter;
    private ArrayList<TeamPlayersBean.Player> dataList = new ArrayList<>();
    private String[] samplePlayerNames = {"Davante Adams", "Aaron Rodgers", "JK Scott", "Jaire Alexander"
            , "David Bakhtiari", "Evan Baylis", "Kapri Bibbs", "Tim Boyle"};
    private TeamDetailsPresenterClass teamDetailsPresenterClass;
    private SwipeRefreshLayout swipe_refresh;
    private String teamName, divisionName, teamID,clubName;

    public static TeamPlayersFragment getInstance(String teamName, String divisionName, String teamId,String clubName) {
        TeamPlayersFragment teamPlayersFragment = new TeamPlayersFragment();
        Bundle bundle = new Bundle();
        bundle.putString("TEAM_NAME", teamName);
        bundle.putString("DIVISION_NAME", divisionName);
        bundle.putString("TEAM_ID", teamId);
        bundle.putString("CLUB_NAME", clubName);
        teamPlayersFragment.setArguments(bundle);
        return teamPlayersFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.single_recycler_view_2, container, false);
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
        if (getActivity() instanceof TeamDetailsActivity) {
            swipe_refresh.setRefreshing(false);
            swipe_refresh.setEnabled(false);
        }
        statsRV.setPadding(0, 10, 0, 2);

        teamDetailsPresenterClass = new TeamDetailsPresenterClass(getActivity(), this);
        Bundle bundle = getArguments();
        if (bundle != null) {
            teamName = bundle.getString("TEAM_NAME");
            divisionName = bundle.getString("DIVISION_NAME");
            teamID = bundle.getString("TEAM_ID");
            clubName = bundle.getString("CLUB_NAME");

            teamDetailsPresenterClass.getTeamID(teamID != null ? teamID : "33");
        }

        swipe_refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipe_refresh.setRefreshing(false);
            }
        });

    }


    @Override
    public void onPlayerItemClick(int position) {
        Intent intent = new Intent(context, PlayerDetailsActivity.class);
        intent.putExtra("AGE", dataList.get(position).getDateOfBirth());
        intent.putExtra("PLAYER_NAME", dataList.get(position).getFullName());
        intent.putExtra("TEAM_NAME", teamName);
        intent.putExtra("DIVISION_NAME", divisionName);
        intent.putExtra("CLUB_NAME", clubName);
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
        if (teamPlayersBean != null && teamPlayersBean.getPlayers() != null && teamPlayersBean.getPlayers().size() > 0) {
            this.dataList = teamPlayersBean.getPlayers();
            statsRV.setLayoutManager(new LinearLayoutManager(context));
            adapter = new TeamPlayersAdapter(context, this.dataList, this);
            statsRV.setAdapter(adapter);
            statsRV.setVisibility(View.VISIBLE);
            no_data.setVisibility(View.GONE);
        } else {
            statsRV.setVisibility(View.GONE);
            no_data.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void getError(String error, boolean isVisible) {

    }


    @Override
    public void TeamData(String headCoach, String stadium) {

    }
}

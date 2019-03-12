package com.elintminds.osdb.ui.team_details_screen.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseFragment;
import com.elintminds.osdb.ui.player_details_screen.view.PlayerDetailsActivity;
import com.elintminds.osdb.ui.team_details_screen.adapters.TeamPlayersAdapter;
import com.elintminds.osdb.ui.team_details_screen.beans.TeamPlayersBean;
import com.elintminds.osdb.ui.team_details_screen.presenter.TeamDetailsPresenterClass;

import java.util.ArrayList;

public class TeamPlayersFragment extends BaseFragment implements TeamDetailsView.TeamPlayersAdapterListener ,TeamDetailsView.TeamPlayersView{
    public static final String TAG = "TeamPlayersFragment";

    private Context context;
    private RecyclerView statsRV;
    private TeamPlayersAdapter adapter;
    private ArrayList<TeamPlayersBean.Player> dataList = new ArrayList<>();
    private String[] samplePlayerNames = {"Davante Adams", "Aaron Rodgers", "JK Scott", "Jaire Alexander"
            , "David Bakhtiari", "Evan Baylis", "Kapri Bibbs", "Tim Boyle"};
private TeamDetailsPresenterClass teamDetailsPresenterClass;
    public static TeamPlayersFragment getInstance()
    {
        return new TeamPlayersFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        for (String pName: samplePlayerNames) {
//            TeamPlayersBean item = new TeamPlayersBean();
//            item.setPlayerName(pName);
//            dataList.add(item);
//        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.single_recycler_view, container, false);
    }


    @Override
    protected void setUp(View view)
    {
        context = getContext();
        statsRV = view.findViewById(R.id.recycler_view);
        statsRV.setPadding(0,10,0,2);
        adapter = new TeamPlayersAdapter(context, dataList, this);
        statsRV.setAdapter(adapter);

        teamDetailsPresenterClass=new TeamDetailsPresenterClass(getActivity(),this);
        teamDetailsPresenterClass.getTeamID("33");
    }



    @Override
    public void onPlayerItemClick(int position)
    {
        Intent intent = new Intent(context, PlayerDetailsActivity.class);
//        intent.putExtra("TITLE", dataList.get(position).getPlayerName());

        startActivity(intent);
    }

    @Override
    public void getPlayers(TeamPlayersBean teamPlayersBean) {
        adapter.setDataList(teamPlayersBean.getPlayers());
    }

    @Override
    public void getError(String error) {

    }
}

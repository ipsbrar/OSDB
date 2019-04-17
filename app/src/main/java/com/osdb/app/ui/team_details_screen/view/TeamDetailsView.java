package com.osdb.app.ui.team_details_screen.view;

import com.osdb.app.ui.base.view.BaseView;
import com.osdb.app.ui.team_details_screen.beans.TeamPlayersBean;

public interface TeamDetailsView extends BaseView
{
    interface TeamPlayersAdapterListener
    {
        void onPlayerItemClick(int position);
    }

     interface TeamPlayersView  extends TeamDetailsView{
        void getPlayers(TeamPlayersBean teamPlayersBean);
        void getError(String error, boolean isVisible);
    }

    void TeamData(String headCoach,String stadium);
    void getError(String error, boolean isVisible);
}

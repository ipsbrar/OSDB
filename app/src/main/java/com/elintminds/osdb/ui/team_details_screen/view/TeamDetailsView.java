package com.elintminds.osdb.ui.team_details_screen.view;

import com.elintminds.osdb.ui.base.view.BaseView;
import com.elintminds.osdb.ui.team_details_screen.beans.TeamPlayersBean;

public interface TeamDetailsView extends BaseView
{
    interface TeamPlayersAdapterListener
    {
        void onPlayerItemClick(int position);
    }

     interface TeamPlayersView  extends TeamDetailsView{
        void getPlayers(TeamPlayersBean teamPlayersBean);
        void getError(String error);
    }
}

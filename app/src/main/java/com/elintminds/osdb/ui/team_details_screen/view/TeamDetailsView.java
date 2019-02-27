package com.elintminds.osdb.ui.team_details_screen.view;

import com.elintminds.osdb.ui.base.view.BaseView;

public interface TeamDetailsView extends BaseView
{
    interface TeamPlayersAdapterListener
    {
        void onPlayerItemClick(int position);
    }
}

package com.elintminds.osdb.ui.particular_sport_screen.view;

import com.elintminds.osdb.ui.base.view.BaseView;

public interface SportScreenView extends BaseView
{
    interface TeamsExpandableItemsListener
    {
        void onTeamClick(int groupPos, int childPos);
    }
}

package com.osdb.pro.ui.particular_sport_screen.view;

import com.osdb.pro.ui.base.view.BaseView;

public interface SportScreenView extends BaseView
{
    interface TeamsExpandableItemsListener
    {
        void onTeamClick(int groupPos, int childPos);
    }
}

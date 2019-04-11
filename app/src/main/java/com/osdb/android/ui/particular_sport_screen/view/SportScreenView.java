package com.osdb.android.ui.particular_sport_screen.view;

import com.osdb.android.ui.base.view.BaseView;

public interface SportScreenView extends BaseView
{
    interface TeamsExpandableItemsListener
    {
        void onTeamClick(int groupPos, int childPos);
    }
}

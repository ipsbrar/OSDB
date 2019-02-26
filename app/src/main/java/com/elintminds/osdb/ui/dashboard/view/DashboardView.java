package com.elintminds.osdb.ui.dashboard.view;

import com.elintminds.osdb.ui.base.view.BaseView;

public interface DashboardView extends BaseView
{
    interface EventsItemsClickListener
    {
        void onShowDetailsClick(int position);
    }

    interface NewsItemsClickListener
    {
        void onNewsClick(int position);
    }

    interface PollOptionListner {

        void onOptionClick(int listPosition,int optionPosition);

    }

    interface SportsAdapterItemClickListener
    {
        void onSportsIconClick(int position);
    }

}

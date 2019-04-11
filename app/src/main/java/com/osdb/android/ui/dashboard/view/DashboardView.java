package com.osdb.android.ui.dashboard.view;

import com.osdb.android.ui.base.view.BaseView;
import com.osdb.android.ui.profile.beans.UserInfo;

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
        void onSportsIconClick(int position, String name);
    }
    void success(UserInfo userBean);
    void error(String error);
}

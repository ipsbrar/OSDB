package com.elintminds.osdb.ui.dashboard.view;

import com.elintminds.osdb.ui.base.view.BaseView;

public interface DashboardView extends BaseView {


    interface PollOptionListner {

        void onOptionClick(int listPosition,int optionPosition);


    }


}

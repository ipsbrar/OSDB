package com.osdb.app.ui.dashboard.view;

import com.osdb.app.ui.base.view.BaseView;
import com.osdb.app.ui.dashboard.beans.PollAdapterBean;

import java.util.ArrayList;

public  interface PollView extends BaseView {


    void getPollData(ArrayList<PollAdapterBean> arrayList);
    void VotePolls(String message);
    void error(String error , boolean isVisible);

}

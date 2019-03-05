package com.elintminds.osdb.ui.dashboard.view;

import com.elintminds.osdb.ui.base.view.BaseView;
import com.elintminds.osdb.ui.dashboard.beans.PollAdapterBean;

import java.util.ArrayList;

public  interface PollView extends BaseView {


    void getPollData(ArrayList<PollAdapterBean> arrayList);

}

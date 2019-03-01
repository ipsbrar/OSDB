package com.elintminds.osdb.ui.dashboard.view;

import com.elintminds.osdb.ui.base.view.BaseView;
import com.elintminds.osdb.ui.dashboard.beans.BornTodayAdapterBean;
import com.elintminds.osdb.ui.dashboard.beans.HomeAdapterListBean;
import com.elintminds.osdb.ui.dashboard.beans.SportsAdapterListBean;

import java.util.ArrayList;

public interface HomeFragmentView extends BaseView {

    void getSportsData(ArrayList<SportsAdapterListBean> sportsList);
    void getHomesData(ArrayList<HomeAdapterListBean> homesData);
    void getBornTodayData(ArrayList<BornTodayAdapterBean> bornTodayData);
    void getError(String error);
}

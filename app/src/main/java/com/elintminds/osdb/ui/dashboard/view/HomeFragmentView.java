package com.elintminds.osdb.ui.dashboard.view;

import com.elintminds.osdb.ui.base.view.BaseView;
import com.elintminds.osdb.ui.dashboard.beans.*;

import java.util.ArrayList;

public interface HomeFragmentView extends BaseView {

    void getSportsData(ArrayList<SportsAdapterListBean> sportsList);

    void getHomesData(ArrayList<HomeAdapterListBean> homesData);

    void getBornTodayData(ArrayList<BornTodayAdapterBean> bornTodayData);

    void getBreakingNews(ArrayList<NewsAdapterBean.BreakingNews> breakingNews);

    void getError(String error);

    void getDoYouKnow(ArrayList<DoYouKnow> doYouKnows);

}

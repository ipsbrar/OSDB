package com.elintminds.osdb.ui.dashboard.view;

import com.elintminds.osdb.ui.base.view.BaseView;
import com.elintminds.osdb.ui.dashboard.beans.*;

import java.util.ArrayList;

public interface HomeFragmentView extends BaseView {

    void getSportsData(ArrayList<SportsAdapterListBean> sportsList);

    void getHomesData(HomeBean homesData);

    void getBornTodayData(ArrayList<HomeBean.BornToday> bornTodayData);

    void getBreakingNews(ArrayList<NewsAdapterBean.BreakingNews> breakingNews);

    void getError(String error);

    void getDoYouKnow(ArrayList<DoYouKnow> doYouKnows);

}

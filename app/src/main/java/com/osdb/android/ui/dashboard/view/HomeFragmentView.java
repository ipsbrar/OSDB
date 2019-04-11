package com.osdb.android.ui.dashboard.view;

import com.osdb.android.ui.base.view.BaseView;
import com.osdb.android.ui.dashboard.beans.*;

public interface HomeFragmentView extends BaseView {

    //    void getSportsData(ArrayList<SportsAdapterListBean> sportsList);
//
    void getHomesData(HomeBean homesData);

    void AddVotePollsSuccess(String jsonObject);
//    void getBornTodayData(ArrayList<HomeBean.BornToday> bornTodayData);
//
//    void getBreakingNews(ArrayList<NewsAdapterBean.BreakingNews> breakingNews);

    void getError(String error);

//    void getDoYouKnow(ArrayList<DoYouKnow> doYouKnows);

}

package com.osdb.pro.ui.dashboard.presenter;

import android.content.Context;
import com.osdb.pro.ui.base.presenter.BasePresenter;
import com.osdb.pro.ui.dashboard.model.HomeFragmentInteractor;
import com.osdb.pro.ui.dashboard.view.HomeFragmentView;

public interface HomeFragmentPresenter<V extends HomeFragmentView, I extends HomeFragmentInteractor> extends BasePresenter<V, I> {
    void getHomeData(String currentDate);

    void AddVote(Context context,String pollID, String optionID);
}

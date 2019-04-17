package com.osdb.app.ui.dashboard.presenter;

import android.content.Context;
import com.osdb.app.ui.base.presenter.BasePresenter;
import com.osdb.app.ui.dashboard.model.HomeFragmentInteractor;
import com.osdb.app.ui.dashboard.view.HomeFragmentView;

public interface HomeFragmentPresenter<V extends HomeFragmentView, I extends HomeFragmentInteractor> extends BasePresenter<V, I> {
    void getHomeData(String currentDate);

    void AddVote(Context context,String pollID, String optionID);
}

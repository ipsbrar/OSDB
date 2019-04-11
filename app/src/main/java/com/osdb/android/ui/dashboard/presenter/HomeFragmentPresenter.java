package com.osdb.android.ui.dashboard.presenter;

import android.content.Context;
import com.osdb.android.ui.base.presenter.BasePresenter;
import com.osdb.android.ui.dashboard.model.HomeFragmentInteractor;
import com.osdb.android.ui.dashboard.view.HomeFragmentView;

public interface HomeFragmentPresenter<V extends HomeFragmentView, I extends HomeFragmentInteractor> extends BasePresenter<V, I> {
    void getHomeData(String currentDate);

    void AddVote(Context context,String pollID, String optionID);
}

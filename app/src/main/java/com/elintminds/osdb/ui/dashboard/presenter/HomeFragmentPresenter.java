package com.elintminds.osdb.ui.dashboard.presenter;

import com.elintminds.osdb.ui.base.presenter.BasePresenter;
import com.elintminds.osdb.ui.dashboard.model.HomeFragmentInteractor;
import com.elintminds.osdb.ui.dashboard.view.HomeFragmentView;

public interface HomeFragmentPresenter<V extends HomeFragmentView, I extends HomeFragmentInteractor> extends BasePresenter<V,I> {
    void getHomeData(String currentDate);

}

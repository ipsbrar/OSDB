package com.osdb.app.ui.dashboard.presenter;

import com.osdb.app.ui.base.presenter.BasePresenter;
import com.osdb.app.ui.dashboard.model.NewsFragmentInteractor;
import com.osdb.app.ui.dashboard.view.NewsFragmentView;

public interface NewsFragmentPresenter<V extends NewsFragmentView, I extends NewsFragmentInteractor> extends BasePresenter<V,I> {
    void getNewsData(int offset);
}

package com.osdb.pro.ui.dashboard.presenter;

import com.osdb.pro.ui.base.presenter.BasePresenter;
import com.osdb.pro.ui.dashboard.model.NewsFragmentInteractor;
import com.osdb.pro.ui.dashboard.view.NewsFragmentView;

public interface NewsFragmentPresenter<V extends NewsFragmentView, I extends NewsFragmentInteractor> extends BasePresenter<V,I> {
    void getNewsData(int offset);
}

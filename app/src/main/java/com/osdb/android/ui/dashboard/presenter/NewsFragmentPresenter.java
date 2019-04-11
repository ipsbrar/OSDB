package com.osdb.android.ui.dashboard.presenter;

import com.osdb.android.ui.base.presenter.BasePresenter;
import com.osdb.android.ui.dashboard.model.NewsFragmentInteractor;
import com.osdb.android.ui.dashboard.view.NewsFragmentView;

public interface NewsFragmentPresenter<V extends NewsFragmentView, I extends NewsFragmentInteractor> extends BasePresenter<V,I> {
    void getNewsData(int offset);
}

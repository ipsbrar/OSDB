package com.elintminds.osdb.ui.dashboard.presenter;

import com.elintminds.osdb.ui.base.presenter.BasePresenter;
import com.elintminds.osdb.ui.dashboard.model.NewsFragmentInteractor;
import com.elintminds.osdb.ui.dashboard.view.NewsFragmentView;

public interface NewsFragmentPresenter<V extends NewsFragmentView, I extends NewsFragmentInteractor> extends BasePresenter<V,I> {
    void getNewsData(int offset);
}

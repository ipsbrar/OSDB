package com.osdb.pro.ui.dashboard.presenter;

import com.osdb.pro.ui.base.presenter.BasePresenter;
import com.osdb.pro.ui.dashboard.model.DashboardInteractor;
import com.osdb.pro.ui.dashboard.view.DashboardView;

public interface DashboardPresenter<V extends DashboardView, I extends DashboardInteractor> extends BasePresenter<V, I> {
    void getUserID();
}

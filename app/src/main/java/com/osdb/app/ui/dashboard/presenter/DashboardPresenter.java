package com.osdb.app.ui.dashboard.presenter;

import com.osdb.app.ui.base.presenter.BasePresenter;
import com.osdb.app.ui.dashboard.model.DashboardInteractor;
import com.osdb.app.ui.dashboard.view.DashboardView;

public interface DashboardPresenter<V extends DashboardView, I extends DashboardInteractor> extends BasePresenter<V, I> {
    void getUserID();
}

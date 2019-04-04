package com.elintminds.osdb.ui.dashboard.presenter;

import com.elintminds.osdb.ui.base.presenter.BasePresenter;
import com.elintminds.osdb.ui.dashboard.model.DashboardInteractor;
import com.elintminds.osdb.ui.dashboard.view.DashboardView;

public interface DashboardPresenter<V extends DashboardView, I extends DashboardInteractor> extends BasePresenter<V, I> {
    void getUserID();
}

package com.osdb.android.ui.dashboard.presenter;

import com.osdb.android.ui.base.presenter.BasePresenter;
import com.osdb.android.ui.dashboard.model.DashboardInteractor;
import com.osdb.android.ui.dashboard.view.DashboardView;

public interface DashboardPresenter<V extends DashboardView, I extends DashboardInteractor> extends BasePresenter<V, I> {
    void getUserID();
}

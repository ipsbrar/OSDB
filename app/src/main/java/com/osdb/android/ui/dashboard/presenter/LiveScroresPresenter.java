package com.osdb.android.ui.dashboard.presenter;

import com.osdb.android.ui.base.presenter.BasePresenter;
import com.osdb.android.ui.dashboard.model.LiveScroresInteractor;
import com.osdb.android.ui.dashboard.view.LiveScroresView;

public interface LiveScroresPresenter<V extends LiveScroresView, I extends LiveScroresInteractor> extends BasePresenter<V,I> {
    void getSportsData();
}

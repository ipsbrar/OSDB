package com.osdb.app.ui.dashboard.presenter;

import com.osdb.app.ui.base.presenter.BasePresenter;
import com.osdb.app.ui.dashboard.model.LiveScroresInteractor;
import com.osdb.app.ui.dashboard.view.LiveScroresView;

public interface LiveScroresPresenter<V extends LiveScroresView, I extends LiveScroresInteractor> extends BasePresenter<V,I> {
    void getSportsData();
}

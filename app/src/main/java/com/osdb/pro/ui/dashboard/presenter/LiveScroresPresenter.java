package com.osdb.pro.ui.dashboard.presenter;

import com.osdb.pro.ui.base.presenter.BasePresenter;
import com.osdb.pro.ui.dashboard.model.LiveScroresInteractor;
import com.osdb.pro.ui.dashboard.view.LiveScroresView;

public interface LiveScroresPresenter<V extends LiveScroresView, I extends LiveScroresInteractor> extends BasePresenter<V,I> {
    void getSportsData();
}

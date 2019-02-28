package com.elintminds.osdb.ui.dashboard.presenter;

import com.elintminds.osdb.ui.base.presenter.BasePresenter;
import com.elintminds.osdb.ui.dashboard.model.LiveScroresInteractor;
import com.elintminds.osdb.ui.dashboard.view.LiveScroresView;

public interface LiveScroresPresenter<V extends LiveScroresView, I extends LiveScroresInteractor> extends BasePresenter<V,I> {
    void getSportsData();
}

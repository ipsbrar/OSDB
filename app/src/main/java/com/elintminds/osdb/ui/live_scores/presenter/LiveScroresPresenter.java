package com.elintminds.osdb.ui.live_scores.presenter;

import com.elintminds.osdb.ui.base.presenter.BasePresenter;
import com.elintminds.osdb.ui.live_scores.model.LiveScroresInteractor;
import com.elintminds.osdb.ui.live_scores.view.LiveScroresView;

public interface LiveScroresPresenter<V extends LiveScroresView, I extends LiveScroresInteractor> extends BasePresenter<V,I> {
}

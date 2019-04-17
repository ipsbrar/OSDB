package com.osdb.app.ui.dashboard.presenter;

import com.osdb.app.ui.base.presenter.BasePresenter;
import com.osdb.app.ui.dashboard.model.DiscussionInteractor;
import com.osdb.app.ui.dashboard.view.DiscussionView;

public interface DiscussionPresenter <V extends DiscussionView, I extends DiscussionInteractor> extends BasePresenter<V, I> {
void getDiscussionData();
}

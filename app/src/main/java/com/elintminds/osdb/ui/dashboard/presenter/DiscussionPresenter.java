package com.elintminds.osdb.ui.dashboard.presenter;

import com.elintminds.osdb.ui.base.presenter.BasePresenter;
import com.elintminds.osdb.ui.dashboard.model.DiscussionInteractor;
import com.elintminds.osdb.ui.dashboard.view.DiscussionView;

public interface DiscussionPresenter <V extends DiscussionView, I extends DiscussionInteractor> extends BasePresenter<V, I> {
void getDiscussionData();
}

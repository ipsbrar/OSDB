package com.osdb.pro.ui.dashboard.presenter;

import com.osdb.pro.ui.base.presenter.BasePresenter;
import com.osdb.pro.ui.dashboard.model.DiscussionInteractor;
import com.osdb.pro.ui.dashboard.view.DiscussionView;

public interface DiscussionPresenter <V extends DiscussionView, I extends DiscussionInteractor> extends BasePresenter<V, I> {
void getDiscussionData();
}

package com.osdb.android.ui.dashboard.presenter;

import com.osdb.android.ui.base.presenter.BasePresenter;
import com.osdb.android.ui.dashboard.model.DiscussionInteractor;
import com.osdb.android.ui.dashboard.view.DiscussionView;

public interface DiscussionPresenter <V extends DiscussionView, I extends DiscussionInteractor> extends BasePresenter<V, I> {
void getDiscussionData();
}

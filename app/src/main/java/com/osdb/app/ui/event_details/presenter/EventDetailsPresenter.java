package com.osdb.app.ui.event_details.presenter;

import com.osdb.app.ui.base.presenter.BasePresenter;
import com.osdb.app.ui.event_details.model.EventDetailsInteractor;
import com.osdb.app.ui.event_details.view.EventDetailsView;

public interface EventDetailsPresenter<V extends EventDetailsView, I extends EventDetailsInteractor> extends BasePresenter<V, I>
{
}

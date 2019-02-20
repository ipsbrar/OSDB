package com.elintminds.osdb.ui.event_details.presenter;

import com.elintminds.osdb.ui.base.presenter.BasePresenter;
import com.elintminds.osdb.ui.event_details.model.EventDetailsInteractor;
import com.elintminds.osdb.ui.event_details.view.EventDetailsView;

public interface EventDetailsPresenter<V extends EventDetailsView, I extends EventDetailsInteractor> extends BasePresenter<V, I>
{
}

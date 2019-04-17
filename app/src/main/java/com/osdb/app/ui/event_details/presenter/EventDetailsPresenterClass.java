package com.osdb.app.ui.event_details.presenter;

import android.content.Context;
import com.osdb.app.data.app_prefs.AppPreferenceHelperClass;
import com.osdb.app.ui.base.presenter.BasePresenterClass;
import com.osdb.app.ui.event_details.model.EventDetailsInteractor;
import com.osdb.app.ui.event_details.model.EventDetailsInteractorClass;
import com.osdb.app.ui.event_details.view.EventDetailsView;

public class EventDetailsPresenterClass<V extends EventDetailsView, I extends EventDetailsInteractor>
        extends BasePresenterClass<V, I> implements EventDetailsPresenter<V, I>
{
    private EventDetailsPresenterClass(Context context, I interactor, V view) {
        super(context, interactor, view);
    }

    public EventDetailsPresenterClass(Context context, V view) {
        this(context, (I) new EventDetailsInteractorClass(new AppPreferenceHelperClass(context), context), view);
    }
}

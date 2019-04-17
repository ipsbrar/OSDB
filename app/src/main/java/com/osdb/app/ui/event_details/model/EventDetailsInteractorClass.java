package com.osdb.app.ui.event_details.model;

import android.content.Context;
import com.osdb.app.data.app_prefs.PreferenceHelper;
import com.osdb.app.ui.base.model.BaseInteractorClass;

public class EventDetailsInteractorClass extends BaseInteractorClass implements EventDetailsInteractor
{
    public EventDetailsInteractorClass(PreferenceHelper prefHelper, Context context)
    {
        super(prefHelper, context);
    }
}

package com.elintminds.osdb.ui.event_details.model;

import android.content.Context;
import com.elintminds.osdb.data.app_prefs.PreferenceHelper;
import com.elintminds.osdb.ui.base.model.BaseInteractorClass;

public class EventDetailsInteractorClass extends BaseInteractorClass implements EventDetailsInteractor
{
    public EventDetailsInteractorClass(PreferenceHelper prefHelper, Context context)
    {
        super(prefHelper, context);
    }
}

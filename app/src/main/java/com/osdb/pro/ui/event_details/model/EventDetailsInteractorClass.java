package com.osdb.pro.ui.event_details.model;

import android.content.Context;
import com.osdb.pro.data.app_prefs.PreferenceHelper;
import com.osdb.pro.ui.base.model.BaseInteractorClass;

public class EventDetailsInteractorClass extends BaseInteractorClass implements EventDetailsInteractor
{
    public EventDetailsInteractorClass(PreferenceHelper prefHelper, Context context)
    {
        super(prefHelper, context);
    }
}

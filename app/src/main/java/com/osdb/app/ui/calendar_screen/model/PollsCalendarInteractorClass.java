package com.osdb.app.ui.calendar_screen.model;

import android.content.Context;
import com.osdb.app.data.app_prefs.PreferenceHelper;
import com.osdb.app.ui.base.model.BaseInteractorClass;

public class PollsCalendarInteractorClass extends BaseInteractorClass implements PollsCalendarInteractor
{
    public PollsCalendarInteractorClass(PreferenceHelper prefHelper, Context context)
    {
        super(prefHelper, context);
    }
}

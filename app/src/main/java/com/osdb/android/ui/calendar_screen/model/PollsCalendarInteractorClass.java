package com.osdb.android.ui.calendar_screen.model;

import android.content.Context;
import com.osdb.android.data.app_prefs.PreferenceHelper;
import com.osdb.android.ui.base.model.BaseInteractorClass;

public class PollsCalendarInteractorClass extends BaseInteractorClass implements PollsCalendarInteractor
{
    public PollsCalendarInteractorClass(PreferenceHelper prefHelper, Context context)
    {
        super(prefHelper, context);
    }
}

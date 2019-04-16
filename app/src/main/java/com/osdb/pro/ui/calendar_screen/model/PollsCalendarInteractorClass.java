package com.osdb.pro.ui.calendar_screen.model;

import android.content.Context;
import com.osdb.pro.data.app_prefs.PreferenceHelper;
import com.osdb.pro.ui.base.model.BaseInteractorClass;

public class PollsCalendarInteractorClass extends BaseInteractorClass implements PollsCalendarInteractor
{
    public PollsCalendarInteractorClass(PreferenceHelper prefHelper, Context context)
    {
        super(prefHelper, context);
    }
}

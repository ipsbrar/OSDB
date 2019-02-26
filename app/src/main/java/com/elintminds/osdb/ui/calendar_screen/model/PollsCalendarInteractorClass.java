package com.elintminds.osdb.ui.calendar_screen.model;

import android.content.Context;
import com.elintminds.osdb.data.app_prefs.PreferenceHelper;
import com.elintminds.osdb.ui.base.model.BaseInteractorClass;

public class PollsCalendarInteractorClass extends BaseInteractorClass implements PollsCalendarInteractor
{
    public PollsCalendarInteractorClass(PreferenceHelper prefHelper, Context context)
    {
        super(prefHelper, context);
    }
}

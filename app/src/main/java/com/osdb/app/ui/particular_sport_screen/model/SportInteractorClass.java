package com.osdb.app.ui.particular_sport_screen.model;

import android.content.Context;
import com.osdb.app.data.app_prefs.PreferenceHelper;
import com.osdb.app.ui.base.model.BaseInteractorClass;

public class SportInteractorClass extends BaseInteractorClass implements SportInteractor
{
    public SportInteractorClass(PreferenceHelper prefHelper, Context context)
    {
        super(prefHelper, context);
    }
}

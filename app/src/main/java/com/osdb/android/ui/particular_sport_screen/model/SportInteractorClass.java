package com.osdb.android.ui.particular_sport_screen.model;

import android.content.Context;
import com.osdb.android.data.app_prefs.PreferenceHelper;
import com.osdb.android.ui.base.model.BaseInteractorClass;

public class SportInteractorClass extends BaseInteractorClass implements SportInteractor
{
    public SportInteractorClass(PreferenceHelper prefHelper, Context context)
    {
        super(prefHelper, context);
    }
}

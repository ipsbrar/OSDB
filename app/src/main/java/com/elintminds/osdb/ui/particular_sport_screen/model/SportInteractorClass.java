package com.elintminds.osdb.ui.particular_sport_screen.model;

import android.content.Context;
import com.elintminds.osdb.data.app_prefs.PreferenceHelper;
import com.elintminds.osdb.ui.base.model.BaseInteractorClass;

public class SportInteractorClass extends BaseInteractorClass implements SportInteractor
{
    public SportInteractorClass(PreferenceHelper prefHelper, Context context)
    {
        super(prefHelper, context);
    }
}

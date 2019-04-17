package com.osdb.app.ui.settings.model;

import android.content.Context;
import com.osdb.app.data.app_prefs.PreferenceHelper;
import com.osdb.app.ui.base.model.BaseInteractorClass;

public class SettingsInteractorClass extends BaseInteractorClass implements SettingsInteractor
{
    public SettingsInteractorClass(PreferenceHelper prefHelper, Context context)
    {
        super(prefHelper, context);
    }
}

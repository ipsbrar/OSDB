package com.osdb.android.ui.settings.model;

import android.content.Context;
import com.osdb.android.data.app_prefs.PreferenceHelper;
import com.osdb.android.ui.base.model.BaseInteractorClass;

public class SettingsInteractorClass extends BaseInteractorClass implements SettingsInteractor
{
    public SettingsInteractorClass(PreferenceHelper prefHelper, Context context)
    {
        super(prefHelper, context);
    }
}

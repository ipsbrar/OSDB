package com.osdb.pro.ui.settings.model;

import android.content.Context;
import com.osdb.pro.data.app_prefs.PreferenceHelper;
import com.osdb.pro.ui.base.model.BaseInteractorClass;

public class SettingsInteractorClass extends BaseInteractorClass implements SettingsInteractor
{
    public SettingsInteractorClass(PreferenceHelper prefHelper, Context context)
    {
        super(prefHelper, context);
    }
}

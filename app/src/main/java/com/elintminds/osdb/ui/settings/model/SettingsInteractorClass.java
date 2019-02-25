package com.elintminds.osdb.ui.settings.model;

import android.content.Context;
import com.elintminds.osdb.data.app_prefs.PreferenceHelper;
import com.elintminds.osdb.ui.base.model.BaseInteractorClass;

public class SettingsInteractorClass extends BaseInteractorClass implements SettingsInteractor
{
    public SettingsInteractorClass(PreferenceHelper prefHelper, Context context)
    {
        super(prefHelper, context);
    }
}

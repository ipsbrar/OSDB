package com.osdb.android.ui.welcome_screen.model;

import android.content.Context;
import com.osdb.android.data.app_prefs.PreferenceHelper;
import com.osdb.android.ui.base.model.BaseInteractorClass;

public class WelcomeInteractorClass extends BaseInteractorClass implements WelcomeInteractor
{
    public WelcomeInteractorClass(PreferenceHelper prefHelper, Context context) {
        super(prefHelper, context);
    }
}

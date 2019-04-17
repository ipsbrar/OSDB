package com.osdb.app.ui.welcome_screen.model;

import android.content.Context;
import com.osdb.app.data.app_prefs.PreferenceHelper;
import com.osdb.app.ui.base.model.BaseInteractorClass;

public class WelcomeInteractorClass extends BaseInteractorClass implements WelcomeInteractor
{
    public WelcomeInteractorClass(PreferenceHelper prefHelper, Context context) {
        super(prefHelper, context);
    }
}

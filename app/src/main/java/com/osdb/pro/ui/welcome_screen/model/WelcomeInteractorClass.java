package com.osdb.pro.ui.welcome_screen.model;

import android.content.Context;
import com.osdb.pro.data.app_prefs.PreferenceHelper;
import com.osdb.pro.ui.base.model.BaseInteractorClass;

public class WelcomeInteractorClass extends BaseInteractorClass implements WelcomeInteractor
{
    public WelcomeInteractorClass(PreferenceHelper prefHelper, Context context) {
        super(prefHelper, context);
    }
}

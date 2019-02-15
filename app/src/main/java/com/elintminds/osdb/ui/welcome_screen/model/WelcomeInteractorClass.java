package com.elintminds.osdb.ui.welcome_screen.model;

import android.content.Context;
import com.elintminds.osdb.data.app_prefs.PreferenceHelper;
import com.elintminds.osdb.ui.base.model.BaseInteractorClass;

public class WelcomeInteractorClass extends BaseInteractorClass implements WelcomeInteractor
{
    public WelcomeInteractorClass(PreferenceHelper prefHelper, Context context) {
        super(prefHelper, context);
    }
}

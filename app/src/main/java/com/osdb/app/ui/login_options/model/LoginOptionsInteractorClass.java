package com.osdb.app.ui.login_options.model;

import android.content.Context;
import com.osdb.app.data.app_prefs.PreferenceHelper;
import com.osdb.app.ui.base.model.BaseInteractorClass;

public class LoginOptionsInteractorClass extends BaseInteractorClass implements LoginOptionsInteractor
{
    public LoginOptionsInteractorClass(PreferenceHelper prefHelper, Context context) {
        super(prefHelper, context);
    }
}

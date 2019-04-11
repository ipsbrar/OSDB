package com.osdb.android.ui.login_options.model;

import android.content.Context;
import com.osdb.android.data.app_prefs.PreferenceHelper;
import com.osdb.android.ui.base.model.BaseInteractorClass;

public class LoginOptionsInteractorClass extends BaseInteractorClass implements LoginOptionsInteractor
{
    public LoginOptionsInteractorClass(PreferenceHelper prefHelper, Context context) {
        super(prefHelper, context);
    }
}

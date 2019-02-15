package com.elintminds.osdb.ui.login_options.model;

import android.content.Context;
import com.elintminds.osdb.data.app_prefs.PreferenceHelper;
import com.elintminds.osdb.ui.base.model.BaseInteractorClass;

public class LoginOptionsInteractorClass extends BaseInteractorClass implements LoginOptionsInteractor
{
    public LoginOptionsInteractorClass(PreferenceHelper prefHelper, Context context) {
        super(prefHelper, context);
    }
}

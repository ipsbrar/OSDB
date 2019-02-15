package com.elintminds.osdb.ui.login.model;

import android.content.Context;
import com.elintminds.osdb.data.app_prefs.PreferenceHelper;
import com.elintminds.osdb.ui.base.model.BaseInteractorClass;

public class LoginInteractorClass extends BaseInteractorClass implements LoginInteractor
{
    public LoginInteractorClass(PreferenceHelper prefHelper, Context context) {
        super(prefHelper, context);
    }
}

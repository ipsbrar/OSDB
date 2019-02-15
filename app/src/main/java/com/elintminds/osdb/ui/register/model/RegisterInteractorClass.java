package com.elintminds.osdb.ui.register.model;

import android.content.Context;
import com.elintminds.osdb.data.app_prefs.PreferenceHelper;
import com.elintminds.osdb.ui.base.model.BaseInteractorClass;

public class RegisterInteractorClass extends BaseInteractorClass implements RegisterInteractor
{
    public RegisterInteractorClass(PreferenceHelper prefHelper, Context context) {
        super(prefHelper, context);
    }
}

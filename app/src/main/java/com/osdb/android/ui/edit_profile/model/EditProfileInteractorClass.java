package com.osdb.android.ui.edit_profile.model;

import android.content.Context;
import com.osdb.android.data.app_prefs.PreferenceHelper;
import com.osdb.android.ui.base.model.BaseInteractorClass;

public class EditProfileInteractorClass extends BaseInteractorClass implements EditProfileInteractor
{
    public EditProfileInteractorClass(PreferenceHelper prefHelper, Context context)
    {
        super(prefHelper, context);
    }
}

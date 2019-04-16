package com.osdb.pro.ui.edit_profile.model;

import android.content.Context;
import com.osdb.pro.data.app_prefs.PreferenceHelper;
import com.osdb.pro.ui.base.model.BaseInteractorClass;

public class EditProfileInteractorClass extends BaseInteractorClass implements EditProfileInteractor
{
    public EditProfileInteractorClass(PreferenceHelper prefHelper, Context context)
    {
        super(prefHelper, context);
    }
}

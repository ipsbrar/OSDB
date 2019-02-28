package com.elintminds.osdb.ui.edit_profile.model;

import android.content.Context;
import com.elintminds.osdb.data.app_prefs.PreferenceHelper;
import com.elintminds.osdb.ui.base.model.BaseInteractorClass;

public class EditProfileInteractorClass extends BaseInteractorClass implements EditProfileInteractor
{
    public EditProfileInteractorClass(PreferenceHelper prefHelper, Context context)
    {
        super(prefHelper, context);
    }
}

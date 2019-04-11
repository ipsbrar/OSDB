package com.osdb.android.ui.add_edit_discussion.model;

import android.content.Context;
import com.osdb.android.data.app_prefs.PreferenceHelper;
import com.osdb.android.ui.base.model.BaseInteractorClass;

public class AddEditDiscussionnteractorClass extends BaseInteractorClass implements AddEditDiscussionnteractor
{
    public AddEditDiscussionnteractorClass(PreferenceHelper prefHelper, Context context) {
        super(prefHelper, context);
    }
}

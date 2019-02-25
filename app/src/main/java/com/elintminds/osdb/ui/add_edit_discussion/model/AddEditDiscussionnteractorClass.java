package com.elintminds.osdb.ui.add_edit_discussion.model;

import android.content.Context;
import com.elintminds.osdb.data.app_prefs.PreferenceHelper;
import com.elintminds.osdb.ui.base.model.BaseInteractorClass;

public class AddEditDiscussionnteractorClass extends BaseInteractorClass implements AddEditDiscussionnteractor
{
    public AddEditDiscussionnteractorClass(PreferenceHelper prefHelper, Context context) {
        super(prefHelper, context);
    }
}

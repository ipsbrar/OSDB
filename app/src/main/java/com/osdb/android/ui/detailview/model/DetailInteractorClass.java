package com.osdb.android.ui.detailview.model;

import android.content.Context;
import com.osdb.android.data.app_prefs.PreferenceHelper;
import com.osdb.android.ui.base.model.BaseInteractorClass;

public class DetailInteractorClass extends BaseInteractorClass implements DetailInteractor
{
    public DetailInteractorClass(PreferenceHelper prefHelper, Context context) {
        super(prefHelper, context);
    }
}

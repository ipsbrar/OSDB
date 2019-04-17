package com.osdb.app.ui.detailview.model;

import android.content.Context;
import com.osdb.app.data.app_prefs.PreferenceHelper;
import com.osdb.app.ui.base.model.BaseInteractorClass;

public class DetailInteractorClass extends BaseInteractorClass implements DetailInteractor
{
    public DetailInteractorClass(PreferenceHelper prefHelper, Context context) {
        super(prefHelper, context);
    }
}

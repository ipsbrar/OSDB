package com.osdb.pro.ui.detailview.model;

import android.content.Context;
import com.osdb.pro.data.app_prefs.PreferenceHelper;
import com.osdb.pro.ui.base.model.BaseInteractorClass;

public class DetailInteractorClass extends BaseInteractorClass implements DetailInteractor
{
    public DetailInteractorClass(PreferenceHelper prefHelper, Context context) {
        super(prefHelper, context);
    }
}

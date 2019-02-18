package com.elintminds.osdb.ui.detailview.model;

import android.content.Context;
import com.elintminds.osdb.data.app_prefs.PreferenceHelper;
import com.elintminds.osdb.ui.base.model.BaseInteractorClass;

public class DetailInteractorClass extends BaseInteractorClass implements DetailInteractor
{
    public DetailInteractorClass(PreferenceHelper prefHelper, Context context) {
        super(prefHelper, context);
    }
}

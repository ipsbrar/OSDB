package com.osdb.pro.ui.FilterActivity.Modal;

import android.content.Context;
import com.osdb.pro.data.app_prefs.PreferenceHelper;
import com.osdb.pro.ui.base.model.BaseInteractorClass;

public class FilterActivityInteractorClass extends BaseInteractorClass implements FilterActivityInteractor {

    public FilterActivityInteractorClass(PreferenceHelper prefHelper, Context context) {
        super(prefHelper, context);
    }
}

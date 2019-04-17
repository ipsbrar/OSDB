package com.osdb.app.ui.FilterActivity.Modal;

import android.content.Context;
import com.osdb.app.data.app_prefs.PreferenceHelper;
import com.osdb.app.ui.base.model.BaseInteractorClass;

public class FilterActivityInteractorClass extends BaseInteractorClass implements FilterActivityInteractor {

    public FilterActivityInteractorClass(PreferenceHelper prefHelper, Context context) {
        super(prefHelper, context);
    }
}

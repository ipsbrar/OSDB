package com.elintminds.osdb.ui.dashboard.model;

import android.content.Context;
import com.elintminds.osdb.data.app_prefs.PreferenceHelper;
import com.elintminds.osdb.ui.base.model.BaseInteractorClass;

public class DashboardInteractorClass extends BaseInteractorClass implements DashboardInteractor
{

    public DashboardInteractorClass(PreferenceHelper prefHelper, Context context) {
        super(prefHelper, context);
    }
}

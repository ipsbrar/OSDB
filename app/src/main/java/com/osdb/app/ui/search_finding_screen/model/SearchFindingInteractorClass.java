package com.osdb.app.ui.search_finding_screen.model;

import android.content.Context;
import com.osdb.app.data.app_prefs.PreferenceHelper;
import com.osdb.app.ui.base.model.BaseInteractorClass;

public class SearchFindingInteractorClass extends BaseInteractorClass implements SearchFindingInteractor
{
    public SearchFindingInteractorClass(PreferenceHelper prefHelper, Context context)
    {
        super(prefHelper, context);
    }
}

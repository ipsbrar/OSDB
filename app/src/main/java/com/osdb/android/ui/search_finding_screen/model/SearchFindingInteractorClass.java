package com.osdb.android.ui.search_finding_screen.model;

import android.content.Context;
import com.osdb.android.data.app_prefs.PreferenceHelper;
import com.osdb.android.ui.base.model.BaseInteractorClass;

public class SearchFindingInteractorClass extends BaseInteractorClass implements SearchFindingInteractor
{
    public SearchFindingInteractorClass(PreferenceHelper prefHelper, Context context)
    {
        super(prefHelper, context);
    }
}

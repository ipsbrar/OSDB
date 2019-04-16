package com.osdb.pro.ui.search_finding_screen.model;

import android.content.Context;
import com.osdb.pro.data.app_prefs.PreferenceHelper;
import com.osdb.pro.ui.base.model.BaseInteractorClass;

public class SearchFindingInteractorClass extends BaseInteractorClass implements SearchFindingInteractor
{
    public SearchFindingInteractorClass(PreferenceHelper prefHelper, Context context)
    {
        super(prefHelper, context);
    }
}

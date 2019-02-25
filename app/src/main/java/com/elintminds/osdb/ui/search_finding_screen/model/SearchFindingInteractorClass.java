package com.elintminds.osdb.ui.search_finding_screen.model;

import android.content.Context;
import com.elintminds.osdb.data.app_prefs.PreferenceHelper;
import com.elintminds.osdb.ui.base.model.BaseInteractorClass;

public class SearchFindingInteractorClass extends BaseInteractorClass implements SearchFindingInteractor
{
    public SearchFindingInteractorClass(PreferenceHelper prefHelper, Context context)
    {
        super(prefHelper, context);
    }
}

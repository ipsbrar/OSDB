package com.elintminds.osdb.ui.search_screen.model;

import android.content.Context;
import com.elintminds.osdb.data.app_prefs.PreferenceHelper;
import com.elintminds.osdb.ui.base.model.BaseInteractorClass;

public class SearchScreenInteractorClass extends BaseInteractorClass implements SearchScreenInteractor
{
    public SearchScreenInteractorClass(PreferenceHelper prefHelper, Context context)
    {
        super(prefHelper, context);
    }
}

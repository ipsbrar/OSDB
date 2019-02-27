package com.elintminds.osdb.ui.team_details_screen.model;

import android.content.Context;
import com.elintminds.osdb.data.app_prefs.PreferenceHelper;
import com.elintminds.osdb.ui.base.model.BaseInteractorClass;

public class TeamDetailsInteractorClass extends BaseInteractorClass implements TeamDetailsInteractor
{
    public TeamDetailsInteractorClass(PreferenceHelper prefHelper, Context context)
    {
        super(prefHelper, context);
    }
}

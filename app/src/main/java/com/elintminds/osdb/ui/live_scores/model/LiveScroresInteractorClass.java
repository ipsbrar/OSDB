package com.elintminds.osdb.ui.live_scores.model;

import android.content.Context;
import com.elintminds.osdb.data.app_prefs.PreferenceHelper;
import com.elintminds.osdb.ui.base.model.BaseInteractorClass;

public class LiveScroresInteractorClass extends BaseInteractorClass implements LiveScroresInteractor
{
    public LiveScroresInteractorClass(PreferenceHelper prefHelper, Context context) {
        super(prefHelper, context);
    }
}

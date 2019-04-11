package com.osdb.android.ui.search_finding_screen.model;

import android.content.Context;
import com.osdb.android.data.app_prefs.PreferenceHelper;
import com.osdb.android.ui.base.model.BaseInteractorClass;
import com.osdb.android.ui.search_finding_screen.beans.ScheduleBeans;
import io.reactivex.Observable;

public class ScheduleFragmentInteractorClass  extends BaseInteractorClass implements ScheduleFragmentInteractor
{
    public ScheduleFragmentInteractorClass(PreferenceHelper prefHelper, Context context)
    {
        super(prefHelper, context);
    }

    @Override
    public Observable<ScheduleBeans> fetchSchedules(String slug) {
        return getApiInterface().fetchAllSchedule(slug);
    }
}

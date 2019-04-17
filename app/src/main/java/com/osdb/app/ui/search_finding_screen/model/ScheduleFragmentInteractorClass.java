package com.osdb.app.ui.search_finding_screen.model;

import android.content.Context;
import com.osdb.app.data.app_prefs.PreferenceHelper;
import com.osdb.app.ui.base.model.BaseInteractorClass;
import com.osdb.app.ui.search_finding_screen.beans.ScheduleBeans;
import io.reactivex.Observable;

public class ScheduleFragmentInteractorClass  extends BaseInteractorClass implements ScheduleFragmentInteractor
{
    public ScheduleFragmentInteractorClass(PreferenceHelper prefHelper, Context context)
    {
        super(prefHelper, context);
    }

    @Override
    public Observable<ScheduleBeans> fetchSchedules(String slug,String year,String session) {
        return getApiInterface().fetchAllSchedule(slug,year,session);
    }
}

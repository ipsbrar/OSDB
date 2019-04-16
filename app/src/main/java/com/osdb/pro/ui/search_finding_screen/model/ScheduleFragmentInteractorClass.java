package com.osdb.pro.ui.search_finding_screen.model;

import android.content.Context;
import com.osdb.pro.data.app_prefs.PreferenceHelper;
import com.osdb.pro.ui.base.model.BaseInteractorClass;
import com.osdb.pro.ui.search_finding_screen.beans.ScheduleBeans;
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

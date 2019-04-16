package com.osdb.pro.ui.search_finding_screen.model;

import com.osdb.pro.ui.base.model.BaseInteractor;
import com.osdb.pro.ui.search_finding_screen.beans.ScheduleBeans;
import io.reactivex.Observable;

public interface ScheduleFragmentInteractor extends BaseInteractor {
    Observable<ScheduleBeans> fetchSchedules(String slug,String year,String session);
}

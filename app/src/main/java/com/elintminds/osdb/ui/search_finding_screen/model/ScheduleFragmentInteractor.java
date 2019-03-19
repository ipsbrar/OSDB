package com.elintminds.osdb.ui.search_finding_screen.model;

import com.elintminds.osdb.ui.base.model.BaseInteractor;
import com.elintminds.osdb.ui.search_finding_screen.beans.ScheduleBeans;
import io.reactivex.Observable;

public interface ScheduleFragmentInteractor extends BaseInteractor {
    Observable<ScheduleBeans> fetchSchedules(String slug);
}

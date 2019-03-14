package com.elintminds.osdb.ui.search_finding_screen.presenter;

import com.elintminds.osdb.ui.base.presenter.BasePresenter;
import com.elintminds.osdb.ui.search_finding_screen.model.ScheduleFragmentInteractor;
import com.elintminds.osdb.ui.search_finding_screen.view.ScheduleFragmentView;

public interface ScheduleFragmentPresenter<V extends ScheduleFragmentView, I extends ScheduleFragmentInteractor> extends BasePresenter<V, I> {
void getSlugName(String slug);
}

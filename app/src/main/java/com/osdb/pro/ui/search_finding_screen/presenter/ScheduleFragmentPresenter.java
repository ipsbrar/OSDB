package com.osdb.pro.ui.search_finding_screen.presenter;

import com.osdb.pro.ui.base.presenter.BasePresenter;
import com.osdb.pro.ui.search_finding_screen.model.ScheduleFragmentInteractor;
import com.osdb.pro.ui.search_finding_screen.view.ScheduleFragmentView;

public interface ScheduleFragmentPresenter<V extends ScheduleFragmentView, I extends ScheduleFragmentInteractor> extends BasePresenter<V, I> {
void getSlugName(String slug,String year,String session);
}

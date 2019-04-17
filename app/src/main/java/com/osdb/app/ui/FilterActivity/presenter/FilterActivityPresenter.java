package com.osdb.app.ui.FilterActivity.presenter;

import com.osdb.app.ui.FilterActivity.Modal.FilterActivityInteractor;
import com.osdb.app.ui.FilterActivity.view.FilterActivityView;
import com.osdb.app.ui.base.presenter.BasePresenter;

public interface FilterActivityPresenter<V extends FilterActivityView, I extends FilterActivityInteractor> extends BasePresenter<V,I> {
    void getSeasonData();
    void getWeeklyData(String season);
}

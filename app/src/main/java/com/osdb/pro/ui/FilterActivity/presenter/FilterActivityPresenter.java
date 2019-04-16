package com.osdb.pro.ui.FilterActivity.presenter;

import com.osdb.pro.ui.FilterActivity.Modal.FilterActivityInteractor;
import com.osdb.pro.ui.FilterActivity.view.FilterActivityView;
import com.osdb.pro.ui.base.presenter.BasePresenter;

public interface FilterActivityPresenter<V extends FilterActivityView, I extends FilterActivityInteractor> extends BasePresenter<V,I> {
    void getSeasonData();
    void getWeeklyData(String season);
}

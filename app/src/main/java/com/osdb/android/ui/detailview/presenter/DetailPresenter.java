package com.osdb.android.ui.detailview.presenter;

import com.osdb.android.ui.base.presenter.BasePresenter;
import com.osdb.android.ui.detailview.model.DetailInteractor;
import com.osdb.android.ui.detailview.view.DetailView;

public interface DetailPresenter<V extends DetailView, I extends DetailInteractor> extends BasePresenter<V,I> {
}

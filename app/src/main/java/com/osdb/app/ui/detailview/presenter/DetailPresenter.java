package com.osdb.app.ui.detailview.presenter;

import com.osdb.app.ui.base.presenter.BasePresenter;
import com.osdb.app.ui.detailview.model.DetailInteractor;
import com.osdb.app.ui.detailview.view.DetailView;

public interface DetailPresenter<V extends DetailView, I extends DetailInteractor> extends BasePresenter<V,I> {
}

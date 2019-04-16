package com.osdb.pro.ui.detailview.presenter;

import com.osdb.pro.ui.base.presenter.BasePresenter;
import com.osdb.pro.ui.detailview.model.DetailInteractor;
import com.osdb.pro.ui.detailview.view.DetailView;

public interface DetailPresenter<V extends DetailView, I extends DetailInteractor> extends BasePresenter<V,I> {
}

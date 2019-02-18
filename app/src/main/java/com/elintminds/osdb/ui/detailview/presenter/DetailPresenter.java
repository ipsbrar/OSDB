package com.elintminds.osdb.ui.detailview.presenter;

import com.elintminds.osdb.ui.base.presenter.BasePresenter;
import com.elintminds.osdb.ui.detailview.model.DetailInteractor;
import com.elintminds.osdb.ui.detailview.view.DetailView;

public interface DetailPresenter<V extends DetailView, I extends DetailInteractor> extends BasePresenter<V,I> {
}

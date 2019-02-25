package com.elintminds.osdb.ui.search_screen.presenter;

import com.elintminds.osdb.ui.base.presenter.BasePresenter;
import com.elintminds.osdb.ui.search_screen.model.SearchScreenInteractor;
import com.elintminds.osdb.ui.search_screen.view.SearchScreenView;

public interface SearchScreenPresenter<V extends SearchScreenView, I extends SearchScreenInteractor> extends BasePresenter<V, I>
{

}

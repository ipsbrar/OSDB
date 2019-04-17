package com.osdb.app.ui.search_screen.presenter;

import com.osdb.app.ui.base.presenter.BasePresenter;
import com.osdb.app.ui.search_screen.model.SearchScreenInteractor;
import com.osdb.app.ui.search_screen.view.SearchScreenView;

public interface SearchScreenPresenter<V extends SearchScreenView, I extends SearchScreenInteractor> extends BasePresenter<V, I> {

    void getSearchData( String searchContent , String category);

}

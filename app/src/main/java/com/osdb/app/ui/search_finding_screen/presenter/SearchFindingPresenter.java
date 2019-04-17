package com.osdb.app.ui.search_finding_screen.presenter;

import com.osdb.app.ui.base.presenter.BasePresenter;
import com.osdb.app.ui.search_finding_screen.model.SearchFindingInteractor;
import com.osdb.app.ui.search_finding_screen.view.SearchFindingView;

public interface SearchFindingPresenter<V extends SearchFindingView, I extends SearchFindingInteractor> extends BasePresenter<V, I>
{
}

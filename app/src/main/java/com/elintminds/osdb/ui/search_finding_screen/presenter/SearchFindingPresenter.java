package com.elintminds.osdb.ui.search_finding_screen.presenter;

import com.elintminds.osdb.ui.base.presenter.BasePresenter;
import com.elintminds.osdb.ui.search_finding_screen.model.SearchFindingInteractor;
import com.elintminds.osdb.ui.search_finding_screen.view.SearchFindingView;

public interface SearchFindingPresenter<V extends SearchFindingView, I extends SearchFindingInteractor> extends BasePresenter<V, I>
{
}

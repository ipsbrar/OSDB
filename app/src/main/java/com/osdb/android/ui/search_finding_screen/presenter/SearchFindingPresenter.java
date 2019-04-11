package com.osdb.android.ui.search_finding_screen.presenter;

import com.osdb.android.ui.base.presenter.BasePresenter;
import com.osdb.android.ui.search_finding_screen.model.SearchFindingInteractor;
import com.osdb.android.ui.search_finding_screen.view.SearchFindingView;

public interface SearchFindingPresenter<V extends SearchFindingView, I extends SearchFindingInteractor> extends BasePresenter<V, I>
{
}

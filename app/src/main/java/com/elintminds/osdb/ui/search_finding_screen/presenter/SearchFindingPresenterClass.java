package com.elintminds.osdb.ui.search_finding_screen.presenter;

import android.content.Context;
import com.elintminds.osdb.data.app_prefs.AppPreferenceHelperClass;
import com.elintminds.osdb.ui.base.presenter.BasePresenterClass;
import com.elintminds.osdb.ui.search_finding_screen.model.SearchFindingInteractor;
import com.elintminds.osdb.ui.search_finding_screen.model.SearchFindingInteractorClass;
import com.elintminds.osdb.ui.search_finding_screen.view.SearchFindingView;

public class SearchFindingPresenterClass<V extends SearchFindingView, I extends SearchFindingInteractor>
        extends BasePresenterClass<V, I> implements SearchFindingPresenter<V, I>
{
    private SearchFindingPresenterClass(Context context, I interactor, V view)
    {
        super(context, interactor, view);
    }

    public SearchFindingPresenterClass(Context context, V view)
    {
        this(context, (I) new SearchFindingInteractorClass(new AppPreferenceHelperClass(context), context), view);
    }
}

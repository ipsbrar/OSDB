package com.elintminds.osdb.ui.search_screen.presenter;

import android.content.Context;
import com.elintminds.osdb.data.app_prefs.AppPreferenceHelperClass;
import com.elintminds.osdb.ui.base.presenter.BasePresenterClass;
import com.elintminds.osdb.ui.search_screen.model.SearchScreenInteractor;
import com.elintminds.osdb.ui.search_screen.model.SearchScreenInteractorClass;
import com.elintminds.osdb.ui.search_screen.view.SearchScreenView;

public class SearchScreenPresenterClass<V extends SearchScreenView, I extends SearchScreenInteractor>
        extends BasePresenterClass<V, I> implements SearchScreenPresenter<V, I>
{
    private SearchScreenPresenterClass(Context context, I interactor, V view)
    {
        super(context, interactor, view);
    }

    public SearchScreenPresenterClass(Context context, V view)
    {
        this(context, (I) new SearchScreenInteractorClass(new AppPreferenceHelperClass(context), context), view);
    }
}

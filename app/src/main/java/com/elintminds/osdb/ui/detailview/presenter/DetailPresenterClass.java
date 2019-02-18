package com.elintminds.osdb.ui.detailview.presenter;

import android.content.Context;
import com.elintminds.osdb.data.app_prefs.AppPreferenceHelperClass;
import com.elintminds.osdb.ui.base.presenter.BasePresenterClass;
import com.elintminds.osdb.ui.detailview.model.DetailInteractor;
import com.elintminds.osdb.ui.detailview.model.DetailInteractorClass;
import com.elintminds.osdb.ui.detailview.view.DetailView;

public class DetailPresenterClass<V extends DetailView, I extends DetailInteractor> extends BasePresenterClass<V,I> implements DetailPresenter<V,I>
{
    private DetailPresenterClass(Context context, I interactor, V view) {
        super(context, interactor, view);
    }

    public DetailPresenterClass(Context context, V view) {
        this(context, (I) new DetailInteractorClass(new AppPreferenceHelperClass(context), context), view);
    }
}

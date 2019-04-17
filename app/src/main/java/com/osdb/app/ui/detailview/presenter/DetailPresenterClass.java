package com.osdb.app.ui.detailview.presenter;

import android.content.Context;
import com.osdb.app.data.app_prefs.AppPreferenceHelperClass;
import com.osdb.app.ui.base.presenter.BasePresenterClass;
import com.osdb.app.ui.detailview.model.DetailInteractor;
import com.osdb.app.ui.detailview.model.DetailInteractorClass;
import com.osdb.app.ui.detailview.view.DetailView;

public class DetailPresenterClass<V extends DetailView, I extends DetailInteractor> extends BasePresenterClass<V,I> implements DetailPresenter<V,I>
{
    private DetailPresenterClass(Context context, I interactor, V view) {
        super(context, interactor, view);
    }

    public DetailPresenterClass(Context context, V view) {
        this(context, (I) new DetailInteractorClass(new AppPreferenceHelperClass(context), context), view);
    }
}

package com.elintminds.osdb.ui.dashboard.presenter;

import android.content.Context;
import com.elintminds.osdb.data.app_prefs.AppPreferenceHelperClass;
import com.elintminds.osdb.ui.base.presenter.BasePresenterClass;
import com.elintminds.osdb.ui.dashboard.model.LiveScroresInteractor;
import com.elintminds.osdb.ui.dashboard.model.LiveScroresInteractorClass;
import com.elintminds.osdb.ui.dashboard.view.LiveScroresView;

public class LiveScroresPresenterClass<V extends LiveScroresView, I extends LiveScroresInteractor> extends BasePresenterClass<V,I> implements LiveScroresPresenter<V,I>
{
    private LiveScroresPresenterClass(Context context, I interactor, V view) {
        super(context, interactor, view);
    }

    public LiveScroresPresenterClass(Context context, V view) {
        this(context, (I) new LiveScroresInteractorClass(new AppPreferenceHelperClass(context), context), view);
    }
}

package com.elintminds.osdb.ui.dashboard.presenter;

import android.content.Context;
import com.elintminds.osdb.data.app_prefs.AppPreferenceHelperClass;
import com.elintminds.osdb.ui.base.presenter.BasePresenterClass;
import com.elintminds.osdb.ui.dashboard.model.DashboardInteractor;
import com.elintminds.osdb.ui.dashboard.model.DashboardInteractorClass;
import com.elintminds.osdb.ui.dashboard.view.DashboardView;

public class DashboardPresenterClass<V extends DashboardView, I extends DashboardInteractor>
        extends BasePresenterClass<V, I> implements DashboardPresenter<V, I>
{

    private DashboardPresenterClass(Context context, I interactor, V view) {
        super(context, interactor, view);
    }

    public DashboardPresenterClass(Context context, V view) {
        this(context, (I) new DashboardInteractorClass(new AppPreferenceHelperClass(context), context), view);
    }
}

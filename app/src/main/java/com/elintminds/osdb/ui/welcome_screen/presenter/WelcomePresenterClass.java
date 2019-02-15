package com.elintminds.osdb.ui.welcome_screen.presenter;

import android.content.Context;
import com.elintminds.osdb.data.app_prefs.AppPreferenceHelperClass;
import com.elintminds.osdb.ui.base.presenter.BasePresenterClass;
import com.elintminds.osdb.ui.welcome_screen.model.WelcomeInteractor;
import com.elintminds.osdb.ui.welcome_screen.model.WelcomeInteractorClass;
import com.elintminds.osdb.ui.welcome_screen.view.WelcomeView;

public class WelcomePresenterClass<V extends WelcomeView, I extends WelcomeInteractor> extends BasePresenterClass<V,I> implements WelcomePresenter<V,I>
{
    private WelcomePresenterClass(Context context, I interactor, V view) {
        super(context, interactor, view);
    }

    public WelcomePresenterClass(Context context, V view) {
        this(context, (I) new WelcomeInteractorClass(new AppPreferenceHelperClass(context), context), view);
    }
}

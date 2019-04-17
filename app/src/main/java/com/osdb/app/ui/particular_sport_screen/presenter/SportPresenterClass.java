package com.osdb.app.ui.particular_sport_screen.presenter;

import android.content.Context;
import com.osdb.app.data.app_prefs.AppPreferenceHelperClass;
import com.osdb.app.ui.base.presenter.BasePresenterClass;
import com.osdb.app.ui.particular_sport_screen.model.SportInteractor;
import com.osdb.app.ui.particular_sport_screen.model.SportInteractorClass;
import com.osdb.app.ui.particular_sport_screen.view.SportScreenView;

public class SportPresenterClass<V extends SportScreenView, I extends SportInteractor>
        extends BasePresenterClass<V, I> implements SportPresenter<V, I>
{
    private SportPresenterClass(Context context, I interactor, V view) {
        super(context, interactor, view);
    }

    public SportPresenterClass(Context context, V view) {
        this(context, (I) new SportInteractorClass(new AppPreferenceHelperClass(context), context), view);
    }
}

package com.elintminds.osdb.ui.profile.presenter;

import android.content.Context;
import com.elintminds.osdb.data.app_prefs.AppPreferenceHelperClass;
import com.elintminds.osdb.ui.base.presenter.BasePresenterClass;
import com.elintminds.osdb.ui.base.view.BaseView;
import com.elintminds.osdb.ui.profile.model.ProfileInteractor;
import com.elintminds.osdb.ui.profile.model.ProfileInteractorClass;

public class ProfilePresenterClass<V extends BaseView, I extends ProfileInteractor>
        extends BasePresenterClass<V, I> implements ProfilePresenter<V, I>
{
    private ProfilePresenterClass(Context context, I interactor, V view) {
        super(context, interactor, view);
    }

    public ProfilePresenterClass(Context context, V view) {
        this(context, (I) new ProfileInteractorClass(new AppPreferenceHelperClass(context), context), view);
    }
}

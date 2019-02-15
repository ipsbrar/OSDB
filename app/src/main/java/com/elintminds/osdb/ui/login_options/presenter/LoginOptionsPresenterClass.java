package com.elintminds.osdb.ui.login_options.presenter;

import android.content.Context;
import com.elintminds.osdb.data.app_prefs.AppPreferenceHelperClass;
import com.elintminds.osdb.ui.base.presenter.BasePresenterClass;
import com.elintminds.osdb.ui.login_options.model.LoginOptionsInteractor;
import com.elintminds.osdb.ui.login_options.model.LoginOptionsInteractorClass;
import com.elintminds.osdb.ui.login_options.view.LoginOptionsView;

public class LoginOptionsPresenterClass<V extends LoginOptionsView, I extends LoginOptionsInteractor> extends BasePresenterClass<V,I> implements LoginOptionsPresenter<V,I>
{
    private LoginOptionsPresenterClass(Context context, I interactor, V view) {
        super(context, interactor, view);
    }

    public LoginOptionsPresenterClass(Context context, V view) {
        this(context, (I) new LoginOptionsInteractorClass(new AppPreferenceHelperClass(context), context), view);
    }
}

package com.osdb.android.ui.login_options.presenter;

import android.content.Context;
import com.osdb.android.data.app_prefs.AppPreferenceHelperClass;
import com.osdb.android.ui.base.presenter.BasePresenterClass;
import com.osdb.android.ui.login_options.model.LoginOptionsInteractor;
import com.osdb.android.ui.login_options.model.LoginOptionsInteractorClass;
import com.osdb.android.ui.login_options.view.LoginOptionsView;

public class LoginOptionsPresenterClass<V extends LoginOptionsView, I extends LoginOptionsInteractor> extends BasePresenterClass<V,I> implements LoginOptionsPresenter<V,I>
{
    private LoginOptionsPresenterClass(Context context, I interactor, V view) {
        super(context, interactor, view);
    }

    public LoginOptionsPresenterClass(Context context, V view) {
        this(context, (I) new LoginOptionsInteractorClass(new AppPreferenceHelperClass(context), context), view);
    }
}

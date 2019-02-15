package com.elintminds.osdb.ui.login.presenter;

import android.content.Context;
import com.elintminds.osdb.data.app_prefs.AppPreferenceHelperClass;
import com.elintminds.osdb.ui.base.presenter.BasePresenterClass;
import com.elintminds.osdb.ui.login.model.LoginInteractor;
import com.elintminds.osdb.ui.login.model.LoginInteractorClass;
import com.elintminds.osdb.ui.login.view.LoginView;

public class LoginPresenterClass<V extends LoginView, I extends LoginInteractor> extends BasePresenterClass<V,I> implements LoginPresenter<V,I>
{
    private LoginPresenterClass(Context context, I interactor, V view) {
        super(context, interactor, view);
    }

    public LoginPresenterClass(Context context, V view) {
        this(context, (I) new LoginInteractorClass(new AppPreferenceHelperClass(context), context), view);
    }
}

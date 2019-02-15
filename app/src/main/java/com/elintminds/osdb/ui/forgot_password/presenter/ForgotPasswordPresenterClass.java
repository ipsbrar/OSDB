package com.elintminds.osdb.ui.forgot_password.presenter;

import android.content.Context;
import com.elintminds.osdb.data.app_prefs.AppPreferenceHelperClass;
import com.elintminds.osdb.ui.base.presenter.BasePresenterClass;
import com.elintminds.osdb.ui.forgot_password.model.ForgotPasswordInteractor;
import com.elintminds.osdb.ui.forgot_password.model.ForgotPasswordInteractorClass;
import com.elintminds.osdb.ui.forgot_password.view.ForgotPasswordView;

public class ForgotPasswordPresenterClass<V extends ForgotPasswordView, I extends ForgotPasswordInteractor> extends BasePresenterClass<V,I> implements ForgotPasswordPresenter<V,I>
{
    private ForgotPasswordPresenterClass(Context context, I interactor, V view) {
        super(context, interactor, view);
    }

    public ForgotPasswordPresenterClass(Context context, V view) {
        this(context, (I) new ForgotPasswordInteractorClass(new AppPreferenceHelperClass(context), context), view);
    }
}

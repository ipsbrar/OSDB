package com.osdb.app.ui.forgot_password.presenter;

import android.content.Context;
import com.osdb.app.ui.base.presenter.BasePresenter;
import com.osdb.app.ui.forgot_password.model.ForgotPasswordInteractor;
import com.osdb.app.ui.forgot_password.view.ForgotPasswordView;

public interface ForgotPasswordPresenter<V extends ForgotPasswordView, I extends ForgotPasswordInteractor> extends BasePresenter<V,I> {

    void getEmailToSendResetLink(String email, Context context);

}

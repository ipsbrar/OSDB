package com.osdb.android.ui.forgot_password.presenter;

import android.content.Context;
import com.osdb.android.ui.base.presenter.BasePresenter;
import com.osdb.android.ui.forgot_password.model.ForgotPasswordInteractor;
import com.osdb.android.ui.forgot_password.view.ForgotPasswordView;

public interface ForgotPasswordPresenter<V extends ForgotPasswordView, I extends ForgotPasswordInteractor> extends BasePresenter<V,I> {

    void getEmailToSendResetLink(String email, Context context);

}

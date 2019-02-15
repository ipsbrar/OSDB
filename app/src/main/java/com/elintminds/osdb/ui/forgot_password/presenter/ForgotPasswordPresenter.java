package com.elintminds.osdb.ui.forgot_password.presenter;

import com.elintminds.osdb.ui.base.presenter.BasePresenter;
import com.elintminds.osdb.ui.forgot_password.model.ForgotPasswordInteractor;
import com.elintminds.osdb.ui.forgot_password.view.ForgotPasswordView;

public interface ForgotPasswordPresenter<V extends ForgotPasswordView, I extends ForgotPasswordInteractor> extends BasePresenter<V,I> {
}

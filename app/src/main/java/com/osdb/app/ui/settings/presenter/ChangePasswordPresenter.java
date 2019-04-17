package com.osdb.app.ui.settings.presenter;

import com.osdb.app.ui.base.presenter.BasePresenter;
import com.osdb.app.ui.settings.model.ChangePasswordInteractor;
import com.osdb.app.ui.settings.view.ChangePasswordView;

public interface ChangePasswordPresenter<V extends ChangePasswordView, I extends ChangePasswordInteractor> extends BasePresenter<V,I> {
void getUserDetails(String id, String oldPassword, String password, String confirmPassword);
}

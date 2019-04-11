package com.osdb.android.ui.settings.presenter;

import com.osdb.android.ui.base.presenter.BasePresenter;
import com.osdb.android.ui.settings.model.ChangePasswordInteractor;
import com.osdb.android.ui.settings.view.ChangePasswordView;

public interface ChangePasswordPresenter<V extends ChangePasswordView, I extends ChangePasswordInteractor> extends BasePresenter<V,I> {
void getUserDetails(String id, String oldPassword, String password, String confirmPassword);
}

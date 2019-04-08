package com.elintminds.osdb.ui.settings.presenter;

import com.elintminds.osdb.ui.base.presenter.BasePresenter;
import com.elintminds.osdb.ui.settings.model.ChangePasswordInteractor;
import com.elintminds.osdb.ui.settings.view.ChangePasswordView;

public interface ChangePasswordPresenter<V extends ChangePasswordView, I extends ChangePasswordInteractor> extends BasePresenter<V,I> {
void getUserDetails(String id, String oldPassword, String password, String confirmPassword);
}

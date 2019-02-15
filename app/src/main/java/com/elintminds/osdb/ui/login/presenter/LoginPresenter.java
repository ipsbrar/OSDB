package com.elintminds.osdb.ui.login.presenter;

import com.elintminds.osdb.ui.base.presenter.BasePresenter;
import com.elintminds.osdb.ui.login.model.LoginInteractor;
import com.elintminds.osdb.ui.login.view.LoginView;

public interface LoginPresenter<V extends LoginView, I extends LoginInteractor> extends BasePresenter<V,I> {
}

package com.osdb.pro.ui.login_options.presenter;

import com.osdb.pro.ui.base.presenter.BasePresenter;
import com.osdb.pro.ui.login_options.model.LoginOptionsInteractor;
import com.osdb.pro.ui.login_options.view.LoginOptionsView;

public interface LoginOptionsPresenter<V extends LoginOptionsView, I extends LoginOptionsInteractor> extends BasePresenter<V,I> {
}

package com.osdb.android.ui.login_options.presenter;

import com.osdb.android.ui.base.presenter.BasePresenter;
import com.osdb.android.ui.login_options.model.LoginOptionsInteractor;
import com.osdb.android.ui.login_options.view.LoginOptionsView;

public interface LoginOptionsPresenter<V extends LoginOptionsView, I extends LoginOptionsInteractor> extends BasePresenter<V,I> {
}

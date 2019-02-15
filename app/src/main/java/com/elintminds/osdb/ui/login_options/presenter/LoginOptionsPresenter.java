package com.elintminds.osdb.ui.login_options.presenter;

import com.elintminds.osdb.ui.base.presenter.BasePresenter;
import com.elintminds.osdb.ui.login_options.model.LoginOptionsInteractor;
import com.elintminds.osdb.ui.login_options.view.LoginOptionsView;

public interface LoginOptionsPresenter<V extends LoginOptionsView, I extends LoginOptionsInteractor> extends BasePresenter<V,I> {
}

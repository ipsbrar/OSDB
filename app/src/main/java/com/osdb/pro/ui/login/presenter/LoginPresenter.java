package com.osdb.pro.ui.login.presenter;

import com.osdb.pro.ui.base.presenter.BasePresenter;
import com.osdb.pro.ui.login.model.LoginInteractor;
import com.osdb.pro.ui.login.view.LoginView;

public interface LoginPresenter<V extends LoginView, I extends LoginInteractor> extends BasePresenter<V,I> {
    void sendUserValue(String userEmail,String userPassword);
    void onSuccess(String Result);
    void onError(String Error);
}

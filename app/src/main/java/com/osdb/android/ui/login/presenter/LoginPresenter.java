package com.osdb.android.ui.login.presenter;

import com.osdb.android.ui.base.presenter.BasePresenter;
import com.osdb.android.ui.login.model.LoginInteractor;
import com.osdb.android.ui.login.view.LoginView;

public interface LoginPresenter<V extends LoginView, I extends LoginInteractor> extends BasePresenter<V,I> {
    void sendUserValue(String userEmail,String userPassword);
    void onSuccess(String Result);
    void onError(String Error);
}

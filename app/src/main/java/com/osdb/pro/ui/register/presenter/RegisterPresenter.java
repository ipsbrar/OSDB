package com.osdb.pro.ui.register.presenter;

import com.osdb.pro.ui.base.presenter.BasePresenter;
import com.osdb.pro.ui.register.model.RegisterInteractor;
import com.osdb.pro.ui.register.view.RegisterView;

public interface RegisterPresenter<V extends RegisterView, I extends RegisterInteractor> extends BasePresenter<V,I> {
    void getRegisterData(String name, String email, String password, String phoneNumber,String type);
}

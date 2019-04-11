package com.osdb.android.ui.register.presenter;

import com.osdb.android.ui.base.presenter.BasePresenter;
import com.osdb.android.ui.register.model.RegisterInteractor;
import com.osdb.android.ui.register.view.RegisterView;

public interface RegisterPresenter<V extends RegisterView, I extends RegisterInteractor> extends BasePresenter<V,I> {
    void getRegisterData(String name, String email, String password, String phoneNumber,String type);
}

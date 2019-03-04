package com.elintminds.osdb.ui.register.presenter;

import com.elintminds.osdb.ui.base.presenter.BasePresenter;
import com.elintminds.osdb.ui.register.model.RegisterInteractor;
import com.elintminds.osdb.ui.register.view.RegisterView;

public interface RegisterPresenter<V extends RegisterView, I extends RegisterInteractor> extends BasePresenter<V,I> {
    void getRegisterData(String name, String email, String password, String phoneNumber,String type);
}

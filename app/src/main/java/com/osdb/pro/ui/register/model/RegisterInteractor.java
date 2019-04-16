package com.osdb.pro.ui.register.model;

import com.osdb.pro.ui.base.model.BaseInteractor;
import com.osdb.pro.ui.register.beans.RegisterBean;
import io.reactivex.Observable;

public interface RegisterInteractor extends BaseInteractor {
    Observable<RegisterBean> doServerRegister(String name,String email, String password,String phoneNumber,String type);
}

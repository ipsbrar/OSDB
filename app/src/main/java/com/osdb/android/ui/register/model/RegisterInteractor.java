package com.osdb.android.ui.register.model;

import com.osdb.android.ui.base.model.BaseInteractor;
import com.osdb.android.ui.register.beans.RegisterBean;
import io.reactivex.Observable;

public interface RegisterInteractor extends BaseInteractor {
    Observable<RegisterBean> doServerRegister(String name,String email, String password,String phoneNumber,String type);
}

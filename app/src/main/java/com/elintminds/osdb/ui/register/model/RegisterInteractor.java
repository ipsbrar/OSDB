package com.elintminds.osdb.ui.register.model;

import com.elintminds.osdb.ui.base.model.BaseInteractor;
import com.elintminds.osdb.ui.register.beans.RegisterBean;
import io.reactivex.Observable;

public interface RegisterInteractor extends BaseInteractor {
    Observable<RegisterBean> doServerRegister(String name,String email, String password,String phoneNumber,String type);
}

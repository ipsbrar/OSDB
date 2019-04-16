package com.osdb.pro.ui.login.model;

import com.osdb.pro.ui.base.model.BaseInteractor;
import com.osdb.pro.ui.login.beans.UserBean;
import io.reactivex.Observable;

public interface LoginInteractor extends BaseInteractor {
 Observable<UserBean> doServerLogin(String email, String password);
}

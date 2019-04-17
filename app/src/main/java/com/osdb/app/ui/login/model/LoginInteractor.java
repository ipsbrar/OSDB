package com.osdb.app.ui.login.model;

import com.osdb.app.ui.base.model.BaseInteractor;
import com.osdb.app.ui.login.beans.UserBean;
import io.reactivex.Observable;

public interface LoginInteractor extends BaseInteractor {
 Observable<UserBean> doServerLogin(String email, String password);
}

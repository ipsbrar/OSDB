package com.elintminds.osdb.ui.login.model;

import com.elintminds.osdb.ui.base.model.BaseInteractor;
import com.elintminds.osdb.ui.login.beans.UserBean;
import io.reactivex.Observable;

public interface LoginInteractor extends BaseInteractor {
 Observable<UserBean> doServerLogin(String email, String password);
}

package com.osdb.android.ui.login.model;

import com.osdb.android.ui.base.model.BaseInteractor;
import com.osdb.android.ui.login.beans.UserBean;
import io.reactivex.Observable;

public interface LoginInteractor extends BaseInteractor {
 Observable<UserBean> doServerLogin(String email, String password);
}

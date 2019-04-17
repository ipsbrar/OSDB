package com.osdb.app.ui.login.view;

import com.osdb.app.ui.base.view.BaseView;
import com.osdb.app.ui.login.beans.UserBean;

public interface LoginView<T> extends BaseView {

    void onSuccess(UserBean obj);
    void onError(String error);

}

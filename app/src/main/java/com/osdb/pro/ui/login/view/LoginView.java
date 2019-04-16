package com.osdb.pro.ui.login.view;

import com.osdb.pro.ui.base.view.BaseView;
import com.osdb.pro.ui.login.beans.UserBean;

public interface LoginView<T> extends BaseView {

    void onSuccess(UserBean obj);
    void onError(String error);

}

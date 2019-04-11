package com.osdb.android.ui.login.view;

import com.osdb.android.ui.base.view.BaseView;
import com.osdb.android.ui.login.beans.UserBean;

public interface LoginView<T> extends BaseView {

    void onSuccess(UserBean obj);
    void onError(String error);

}

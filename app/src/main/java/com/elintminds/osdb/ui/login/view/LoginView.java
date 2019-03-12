package com.elintminds.osdb.ui.login.view;

import com.elintminds.osdb.ui.base.view.BaseView;
import com.elintminds.osdb.ui.login.beans.UserBean;

public interface LoginView<T> extends BaseView {

    void onSuccess(UserBean obj);
    void onError(String error);

}

package com.elintminds.osdb.ui.login.view;

import com.elintminds.osdb.ui.base.view.BaseView;

public interface LoginView<T> extends BaseView {

    void onSuccess(T obj);
    void onError(String error);

}

package com.osdb.pro.ui.settings.view;

import com.osdb.pro.ui.base.view.BaseView;

public interface ChangePasswordView extends BaseView {
    void success(String message);

    void error(String error);
}

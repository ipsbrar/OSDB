package com.osdb.pro.ui.forgot_password.view;

import com.osdb.pro.ui.base.view.BaseView;

public interface ForgotPasswordView extends BaseView {
    void success(String message);
    void error(String message);
}

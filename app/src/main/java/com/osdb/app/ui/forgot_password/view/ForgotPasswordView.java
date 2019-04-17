package com.osdb.app.ui.forgot_password.view;

import com.osdb.app.ui.base.view.BaseView;

public interface ForgotPasswordView extends BaseView {
    void success(String message);
    void error(String message);
}

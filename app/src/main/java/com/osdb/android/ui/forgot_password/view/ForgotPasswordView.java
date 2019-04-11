package com.osdb.android.ui.forgot_password.view;

import com.osdb.android.ui.base.view.BaseView;

public interface ForgotPasswordView extends BaseView {
    void success(String message);
    void error(String message);
}

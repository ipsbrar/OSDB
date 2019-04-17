package com.osdb.app.ui.settings.view;

import com.osdb.app.ui.base.view.BaseView;

public interface ChangePasswordView extends BaseView {
    void success(String message);

    void error(String error);
}

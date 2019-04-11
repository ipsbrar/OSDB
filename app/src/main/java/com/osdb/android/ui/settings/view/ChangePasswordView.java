package com.osdb.android.ui.settings.view;

import com.osdb.android.ui.base.view.BaseView;

public interface ChangePasswordView extends BaseView {
    void success(String message);

    void error(String error);
}

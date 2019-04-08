package com.elintminds.osdb.ui.settings.view;

import com.elintminds.osdb.ui.base.view.BaseView;

public interface ChangePasswordView extends BaseView {
    void success(String message);

    void error(String error);
}

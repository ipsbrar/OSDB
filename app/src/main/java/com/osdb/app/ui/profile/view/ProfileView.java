package com.osdb.app.ui.profile.view;

import com.osdb.app.ui.base.view.BaseView;
import com.osdb.app.ui.profile.beans.UserInfo;

public interface ProfileView  extends BaseView {
    void success(UserInfo userBean);
    void error(String error);
}

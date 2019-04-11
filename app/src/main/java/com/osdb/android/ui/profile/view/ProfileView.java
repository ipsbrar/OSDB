package com.osdb.android.ui.profile.view;

import com.osdb.android.ui.base.view.BaseView;
import com.osdb.android.ui.profile.beans.UserInfo;

public interface ProfileView  extends BaseView {
    void success(UserInfo userBean);
    void error(String error);
}

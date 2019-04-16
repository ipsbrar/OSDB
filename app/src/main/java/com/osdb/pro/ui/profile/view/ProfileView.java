package com.osdb.pro.ui.profile.view;

import com.osdb.pro.ui.base.view.BaseView;
import com.osdb.pro.ui.profile.beans.UserInfo;

public interface ProfileView  extends BaseView {
    void success(UserInfo userBean);
    void error(String error);
}

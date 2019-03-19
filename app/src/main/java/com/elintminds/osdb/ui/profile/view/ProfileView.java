package com.elintminds.osdb.ui.profile.view;

import com.elintminds.osdb.ui.base.view.BaseView;
import com.elintminds.osdb.ui.login.beans.UserBean;
import com.elintminds.osdb.ui.profile.beans.UserInfo;

public interface ProfileView  extends BaseView {
    void success(UserInfo userBean);
    void error(String error);
}

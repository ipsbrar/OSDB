package com.elintminds.osdb.ui.register.view;

import com.elintminds.osdb.ui.base.view.BaseView;
import com.elintminds.osdb.ui.register.beans.RegisterBean;

public interface RegisterView extends BaseView {
    void getSuccess(RegisterBean registerBean);
    void getError(String msg);
}

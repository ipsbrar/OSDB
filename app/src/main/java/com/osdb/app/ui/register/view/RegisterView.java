package com.osdb.app.ui.register.view;

import com.osdb.app.ui.base.view.BaseView;
import com.osdb.app.ui.register.beans.RegisterBean;

public interface RegisterView extends BaseView {
    void getSuccess(RegisterBean registerBean);
    void getError(String msg);
}

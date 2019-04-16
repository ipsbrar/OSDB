package com.osdb.pro.ui.register.view;

import com.osdb.pro.ui.base.view.BaseView;
import com.osdb.pro.ui.register.beans.RegisterBean;

public interface RegisterView extends BaseView {
    void getSuccess(RegisterBean registerBean);
    void getError(String msg);
}

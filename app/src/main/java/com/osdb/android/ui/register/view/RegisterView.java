package com.osdb.android.ui.register.view;

import com.osdb.android.ui.base.view.BaseView;
import com.osdb.android.ui.register.beans.RegisterBean;

public interface RegisterView extends BaseView {
    void getSuccess(RegisterBean registerBean);
    void getError(String msg);
}

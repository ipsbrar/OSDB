package com.osdb.pro.ui.dashboard.view;

import com.osdb.pro.ui.base.view.BaseView;
import com.osdb.pro.ui.dashboard.beans.DiscussionAdapterBean;

public interface DiscussionView extends BaseView {
    void getSuccess(DiscussionAdapterBean discussData);
    void getError(String error, boolean isVisible);
}

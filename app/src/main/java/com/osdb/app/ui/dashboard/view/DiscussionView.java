package com.osdb.app.ui.dashboard.view;

import com.osdb.app.ui.base.view.BaseView;
import com.osdb.app.ui.dashboard.beans.DiscussionAdapterBean;

public interface DiscussionView extends BaseView {
    void getSuccess(DiscussionAdapterBean discussData);
    void getError(String error, boolean isVisible);
}

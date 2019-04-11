package com.osdb.android.ui.dashboard.view;

import com.osdb.android.ui.base.view.BaseView;
import com.osdb.android.ui.dashboard.beans.DiscussionAdapterBean;

public interface DiscussionView extends BaseView {
    void getSuccess(DiscussionAdapterBean discussData);
    void getError(String error, boolean isVisible);
}

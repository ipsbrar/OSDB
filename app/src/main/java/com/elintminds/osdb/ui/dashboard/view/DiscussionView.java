package com.elintminds.osdb.ui.dashboard.view;

import com.elintminds.osdb.ui.base.view.BaseView;
import com.elintminds.osdb.ui.dashboard.beans.DiscussionAdapterBean;

public interface DiscussionView extends BaseView {
    void getSuccess(DiscussionAdapterBean discussData);
    void getError(String error);
}

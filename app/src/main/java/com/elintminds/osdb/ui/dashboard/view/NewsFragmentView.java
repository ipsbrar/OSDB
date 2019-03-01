package com.elintminds.osdb.ui.dashboard.view;

import com.elintminds.osdb.ui.base.view.BaseView;
import com.elintminds.osdb.ui.dashboard.beans.NewsAdapterBean;

public interface NewsFragmentView extends BaseView {
    void getNewsData(NewsAdapterBean newsList);
    void getError(String error);
}

package com.osdb.app.ui.dashboard.view;

import com.osdb.app.ui.base.view.BaseView;
import com.osdb.app.ui.dashboard.beans.NewsAdapterBean;

public interface NewsFragmentView extends BaseView {
    void getNewsData(NewsAdapterBean newsList);
    void getError(String error);
}

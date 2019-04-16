package com.osdb.pro.ui.dashboard.view;

import com.osdb.pro.ui.base.view.BaseView;
import com.osdb.pro.ui.dashboard.beans.NewsAdapterBean;

public interface NewsFragmentView extends BaseView {
    void getNewsData(NewsAdapterBean newsList);
    void getError(String error);
}

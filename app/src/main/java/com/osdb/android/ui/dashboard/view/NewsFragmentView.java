package com.osdb.android.ui.dashboard.view;

import com.osdb.android.ui.base.view.BaseView;
import com.osdb.android.ui.dashboard.beans.NewsAdapterBean;

public interface NewsFragmentView extends BaseView {
    void getNewsData(NewsAdapterBean newsList);
    void getError(String error);
}

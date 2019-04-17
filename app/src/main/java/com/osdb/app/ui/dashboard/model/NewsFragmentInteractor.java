package com.osdb.app.ui.dashboard.model;

import com.osdb.app.ui.base.model.BaseInteractor;
import com.osdb.app.ui.dashboard.beans.NewsAdapterBean;
import io.reactivex.Observable;

public interface NewsFragmentInteractor extends BaseInteractor {
    Observable<NewsAdapterBean> getAllNewsList(int offset);
}

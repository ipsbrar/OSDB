package com.osdb.pro.ui.dashboard.model;

import com.osdb.pro.ui.base.model.BaseInteractor;
import com.osdb.pro.ui.dashboard.beans.NewsAdapterBean;
import io.reactivex.Observable;

public interface NewsFragmentInteractor extends BaseInteractor {
    Observable<NewsAdapterBean> getAllNewsList(int offset);
}

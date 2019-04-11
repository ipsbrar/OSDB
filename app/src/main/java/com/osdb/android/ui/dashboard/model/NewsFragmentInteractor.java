package com.osdb.android.ui.dashboard.model;

import com.osdb.android.ui.base.model.BaseInteractor;
import com.osdb.android.ui.dashboard.beans.NewsAdapterBean;
import io.reactivex.Observable;

public interface NewsFragmentInteractor extends BaseInteractor {
    Observable<NewsAdapterBean> getAllNewsList(int offset);
}

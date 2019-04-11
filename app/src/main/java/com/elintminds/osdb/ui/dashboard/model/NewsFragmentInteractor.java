package com.elintminds.osdb.ui.dashboard.model;

import com.elintminds.osdb.ui.base.model.BaseInteractor;
import com.elintminds.osdb.ui.dashboard.beans.NewsAdapterBean;
import io.reactivex.Observable;

public interface NewsFragmentInteractor extends BaseInteractor {
    Observable<NewsAdapterBean> getAllNewsList(int offset);
}

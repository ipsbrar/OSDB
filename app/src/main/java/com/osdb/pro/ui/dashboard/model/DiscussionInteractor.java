package com.osdb.pro.ui.dashboard.model;

import com.osdb.pro.ui.base.model.BaseInteractor;
import com.osdb.pro.ui.dashboard.beans.DiscussionAdapterBean;
import io.reactivex.Observable;

public interface DiscussionInteractor extends BaseInteractor {
     Observable<DiscussionAdapterBean> getDiscussion();
}

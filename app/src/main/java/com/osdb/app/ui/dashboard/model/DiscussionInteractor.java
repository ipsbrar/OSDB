package com.osdb.app.ui.dashboard.model;

import com.osdb.app.ui.base.model.BaseInteractor;
import com.osdb.app.ui.dashboard.beans.DiscussionAdapterBean;
import io.reactivex.Observable;

public interface DiscussionInteractor extends BaseInteractor {
     Observable<DiscussionAdapterBean> getDiscussion();
}

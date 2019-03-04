package com.elintminds.osdb.ui.dashboard.model;

import com.elintminds.osdb.ui.base.model.BaseInteractor;
import com.elintminds.osdb.ui.dashboard.beans.DiscussionAdapterBean;
import io.reactivex.Observable;

public interface DiscussionInteractor extends BaseInteractor {
     Observable<DiscussionAdapterBean> getDiscussion();
}

package com.osdb.android.ui.dashboard.model;

import com.osdb.android.ui.base.model.BaseInteractor;
import com.osdb.android.ui.dashboard.beans.DiscussionAdapterBean;
import io.reactivex.Observable;

public interface DiscussionInteractor extends BaseInteractor {
     Observable<DiscussionAdapterBean> getDiscussion();
}

package com.elintminds.osdb.ui.dashboard.model;

import android.content.Context;
import com.elintminds.osdb.data.app_prefs.PreferenceHelper;
import com.elintminds.osdb.ui.base.model.BaseInteractorClass;
import com.elintminds.osdb.ui.dashboard.beans.DiscussionAdapterBean;
import io.reactivex.Observable;

public class DiscussionInteractorClass extends BaseInteractorClass implements DiscussionInteractor
{

    public DiscussionInteractorClass(PreferenceHelper prefHelper, Context context) {
        super(prefHelper, context);
    }

    @Override
    public Observable<DiscussionAdapterBean> getDiscussion() {
        return getApiInterface().fetchDiscussions();
    }
}



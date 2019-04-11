package com.osdb.android.ui.dashboard.model;

import android.content.Context;
import com.osdb.android.data.app_prefs.PreferenceHelper;
import com.osdb.android.ui.base.model.BaseInteractorClass;
import com.osdb.android.ui.dashboard.beans.DiscussionAdapterBean;
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



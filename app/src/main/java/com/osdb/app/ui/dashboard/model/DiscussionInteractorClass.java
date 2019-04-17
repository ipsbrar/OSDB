package com.osdb.app.ui.dashboard.model;

import android.content.Context;
import com.osdb.app.data.app_prefs.PreferenceHelper;
import com.osdb.app.ui.base.model.BaseInteractorClass;
import com.osdb.app.ui.dashboard.beans.DiscussionAdapterBean;
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



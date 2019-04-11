package com.osdb.android.ui.dashboard.model;

import android.content.Context;
import com.osdb.android.data.app_prefs.PreferenceHelper;
import com.osdb.android.ui.base.model.BaseInteractorClass;
import com.osdb.android.ui.profile.beans.UserInfo;
import io.reactivex.Observable;

public class DashboardInteractorClass extends BaseInteractorClass implements DashboardInteractor
{

    public DashboardInteractorClass(PreferenceHelper prefHelper, Context context) {
        super(prefHelper, context);
    }

    @Override
    public Observable<UserInfo> fetchUserInfo() {
        return getApiInterface().fetchUserData();
    }

}

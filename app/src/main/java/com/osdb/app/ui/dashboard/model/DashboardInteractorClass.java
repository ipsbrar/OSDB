package com.osdb.app.ui.dashboard.model;

import android.content.Context;
import com.osdb.app.data.app_prefs.PreferenceHelper;
import com.osdb.app.ui.base.model.BaseInteractorClass;
import com.osdb.app.ui.profile.beans.UserInfo;
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

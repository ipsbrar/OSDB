package com.osdb.pro.ui.dashboard.model;

import android.content.Context;
import com.osdb.pro.data.app_prefs.PreferenceHelper;
import com.osdb.pro.ui.base.model.BaseInteractorClass;
import com.osdb.pro.ui.profile.beans.UserInfo;
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

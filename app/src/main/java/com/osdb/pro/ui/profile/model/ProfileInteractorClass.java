package com.osdb.pro.ui.profile.model;

import android.content.Context;
import com.osdb.pro.data.app_prefs.PreferenceHelper;
import com.osdb.pro.ui.base.model.BaseInteractorClass;
import com.osdb.pro.ui.profile.beans.UserInfo;
import io.reactivex.Observable;

public class ProfileInteractorClass extends BaseInteractorClass implements ProfileInteractor
{
    public ProfileInteractorClass(PreferenceHelper prefHelper, Context context)
    {
        super(prefHelper, context);
    }

    @Override
    public Observable<UserInfo> fetchUserInfo() {
        return getApiInterface().fetchUserData();
    }
}

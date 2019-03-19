package com.elintminds.osdb.ui.profile.model;

import android.content.Context;
import com.elintminds.osdb.data.app_prefs.PreferenceHelper;
import com.elintminds.osdb.ui.base.model.BaseInteractorClass;
import com.elintminds.osdb.ui.profile.beans.UserInfo;
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

package com.osdb.android.ui.profile.model;

import com.osdb.android.ui.base.model.BaseInteractor;
import com.osdb.android.ui.profile.beans.UserInfo;
import io.reactivex.Observable;

public interface ProfileInteractor extends BaseInteractor {
    Observable<UserInfo> fetchUserInfo();
}

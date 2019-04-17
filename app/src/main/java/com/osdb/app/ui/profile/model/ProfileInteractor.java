package com.osdb.app.ui.profile.model;

import com.osdb.app.ui.base.model.BaseInteractor;
import com.osdb.app.ui.profile.beans.UserInfo;
import io.reactivex.Observable;

public interface ProfileInteractor extends BaseInteractor {
    Observable<UserInfo> fetchUserInfo();
}

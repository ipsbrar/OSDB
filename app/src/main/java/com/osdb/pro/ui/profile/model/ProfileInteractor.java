package com.osdb.pro.ui.profile.model;

import com.osdb.pro.ui.base.model.BaseInteractor;
import com.osdb.pro.ui.profile.beans.UserInfo;
import io.reactivex.Observable;

public interface ProfileInteractor extends BaseInteractor {
    Observable<UserInfo> fetchUserInfo();
}

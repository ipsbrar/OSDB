package com.elintminds.osdb.ui.profile.model;

import com.elintminds.osdb.ui.base.model.BaseInteractor;
import com.elintminds.osdb.ui.profile.beans.UserInfo;
import io.reactivex.Observable;

public interface ProfileInteractor extends BaseInteractor {
    Observable<UserInfo> fetchUserInfo();
}

package com.elintminds.osdb.ui.dashboard.model;

import com.elintminds.osdb.ui.base.model.BaseInteractor;
import com.elintminds.osdb.ui.profile.beans.UserInfo;
import io.reactivex.Observable;

public interface DashboardInteractor extends BaseInteractor {
    Observable<UserInfo> fetchUserInfo();
}

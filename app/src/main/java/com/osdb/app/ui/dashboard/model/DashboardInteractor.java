package com.osdb.app.ui.dashboard.model;

import com.osdb.app.ui.base.model.BaseInteractor;
import com.osdb.app.ui.profile.beans.UserInfo;
import io.reactivex.Observable;

public interface DashboardInteractor extends BaseInteractor {
    Observable<UserInfo> fetchUserInfo();
}

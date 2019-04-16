package com.osdb.pro.ui.dashboard.model;

import com.osdb.pro.ui.base.model.BaseInteractor;
import com.osdb.pro.ui.profile.beans.UserInfo;
import io.reactivex.Observable;

public interface DashboardInteractor extends BaseInteractor {
    Observable<UserInfo> fetchUserInfo();
}

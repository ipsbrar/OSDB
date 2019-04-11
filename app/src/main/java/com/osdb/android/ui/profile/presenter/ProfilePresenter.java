package com.osdb.android.ui.profile.presenter;

import com.osdb.android.ui.base.presenter.BasePresenter;
import com.osdb.android.ui.profile.model.ProfileInteractor;
import com.osdb.android.ui.profile.view.ProfileView;

public interface ProfilePresenter<V extends ProfileView, I extends ProfileInteractor> extends BasePresenter<V, I>
{
    void getUserInfo();
}

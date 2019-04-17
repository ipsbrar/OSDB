package com.osdb.app.ui.profile.presenter;

import com.osdb.app.ui.base.presenter.BasePresenter;
import com.osdb.app.ui.profile.model.ProfileInteractor;
import com.osdb.app.ui.profile.view.ProfileView;

public interface ProfilePresenter<V extends ProfileView, I extends ProfileInteractor> extends BasePresenter<V, I>
{
    void getUserInfo();
}

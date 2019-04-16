package com.osdb.pro.ui.profile.presenter;

import com.osdb.pro.ui.base.presenter.BasePresenter;
import com.osdb.pro.ui.profile.model.ProfileInteractor;
import com.osdb.pro.ui.profile.view.ProfileView;

public interface ProfilePresenter<V extends ProfileView, I extends ProfileInteractor> extends BasePresenter<V, I>
{
    void getUserInfo();
}

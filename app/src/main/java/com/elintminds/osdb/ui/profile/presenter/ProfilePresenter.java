package com.elintminds.osdb.ui.profile.presenter;

import com.elintminds.osdb.ui.base.presenter.BasePresenter;
import com.elintminds.osdb.ui.base.view.BaseView;
import com.elintminds.osdb.ui.profile.model.ProfileInteractor;
import com.elintminds.osdb.ui.profile.view.ProfileView;

public interface ProfilePresenter<V extends ProfileView, I extends ProfileInteractor> extends BasePresenter<V, I>
{
    void getUserInfo();
}

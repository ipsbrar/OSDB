package com.osdb.app.ui.edit_profile.presenter;

import com.osdb.app.ui.base.presenter.BasePresenter;
import com.osdb.app.ui.base.view.BaseView;
import com.osdb.app.ui.edit_profile.model.EditProfileInteractor;
import com.osdb.app.ui.edit_profile.view.EditProfileView;

public interface EditProfilePresenter<V extends EditProfileView, I extends EditProfileInteractor> extends BasePresenter<V, I>
{
    void updateUserValue(String name,String phoneNumber,String filePath);
}

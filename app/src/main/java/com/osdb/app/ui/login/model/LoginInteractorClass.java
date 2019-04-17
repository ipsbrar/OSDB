package com.osdb.app.ui.login.model;

import android.content.Context;
import com.osdb.app.data.app_prefs.PreferenceHelper;
import com.osdb.app.ui.base.model.BaseInteractorClass;
import com.osdb.app.ui.login.beans.UserBean;
import io.reactivex.Observable;

public class LoginInteractorClass extends BaseInteractorClass implements LoginInteractor
{
    public LoginInteractorClass(PreferenceHelper prefHelper, Context context) {
        super(prefHelper, context);
    }


    @Override
    public Observable<UserBean> doServerLogin(String email, String password) {
        return getApiInterface().getUserLogin(email, password);
    }
}

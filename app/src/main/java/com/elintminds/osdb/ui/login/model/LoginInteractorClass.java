package com.elintminds.osdb.ui.login.model;

import android.content.Context;
import com.elintminds.osdb.data.app_prefs.PreferenceHelper;
import com.elintminds.osdb.ui.base.model.BaseInteractorClass;
import com.elintminds.osdb.ui.login.beans.UserBean;
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

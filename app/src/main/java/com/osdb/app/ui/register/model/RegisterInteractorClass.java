package com.osdb.app.ui.register.model;

import android.content.Context;
import com.osdb.app.data.app_prefs.PreferenceHelper;
import com.osdb.app.ui.base.model.BaseInteractorClass;
import com.osdb.app.ui.register.beans.RegisterBean;
import io.reactivex.Observable;

public class RegisterInteractorClass extends BaseInteractorClass implements RegisterInteractor
{
    public RegisterInteractorClass(PreferenceHelper prefHelper, Context context) {
        super(prefHelper, context);
    }

    @Override
    public Observable<RegisterBean> doServerRegister(String name, String email, String password, String phoneNumber, String type) {
        return getApiInterface().getUserRegister(name,email,password,phoneNumber,type);
    }
}

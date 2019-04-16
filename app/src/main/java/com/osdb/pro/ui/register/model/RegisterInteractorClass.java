package com.osdb.pro.ui.register.model;

import android.content.Context;
import com.osdb.pro.data.app_prefs.PreferenceHelper;
import com.osdb.pro.ui.base.model.BaseInteractorClass;
import com.osdb.pro.ui.register.beans.RegisterBean;
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

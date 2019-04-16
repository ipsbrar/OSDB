package com.osdb.pro.ui.forgot_password.model;

import android.content.Context;
import com.osdb.pro.data.app_prefs.PreferenceHelper;
import com.osdb.pro.ui.base.model.BaseInteractorClass;
import com.osdb.pro.ui.forgot_password.ForgotPasswordBean;
import io.reactivex.Observable;
import retrofit2.Response;

public class ForgotPasswordInteractorClass extends BaseInteractorClass implements ForgotPasswordInteractor
{
    public ForgotPasswordInteractorClass(PreferenceHelper prefHelper, Context context) {
        super(prefHelper, context);
    }

    @Override
    public Observable<Response<ForgotPasswordBean>> getEmailResetLink(String email) {
        return getApiInterface().sendForgotPasswordLink(email);
    }
}

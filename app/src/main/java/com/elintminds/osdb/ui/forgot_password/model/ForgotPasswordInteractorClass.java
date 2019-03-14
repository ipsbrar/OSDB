package com.elintminds.osdb.ui.forgot_password.model;

import android.content.Context;
import com.elintminds.osdb.data.app_prefs.PreferenceHelper;
import com.elintminds.osdb.ui.base.model.BaseInteractorClass;
import com.elintminds.osdb.ui.forgot_password.ForgotPasswordBean;
import io.reactivex.Observable;

public class ForgotPasswordInteractorClass extends BaseInteractorClass implements ForgotPasswordInteractor
{
    public ForgotPasswordInteractorClass(PreferenceHelper prefHelper, Context context) {
        super(prefHelper, context);
    }

    @Override
    public Observable<ForgotPasswordBean> getEmailResetLink(String email) {
        return getApiInterface().sendForgotPasswordLink(email);
    }
}

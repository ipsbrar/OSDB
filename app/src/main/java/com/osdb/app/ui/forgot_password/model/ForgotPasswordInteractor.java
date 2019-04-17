package com.osdb.app.ui.forgot_password.model;

import com.osdb.app.ui.base.model.BaseInteractor;
import com.osdb.app.ui.forgot_password.ForgotPasswordBean;
import io.reactivex.Observable;
import retrofit2.Response;

public interface ForgotPasswordInteractor extends BaseInteractor {

    Observable<Response<ForgotPasswordBean>>  getEmailResetLink(String email);
}

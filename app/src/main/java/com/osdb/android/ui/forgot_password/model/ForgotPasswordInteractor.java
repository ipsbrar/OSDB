package com.osdb.android.ui.forgot_password.model;

import com.osdb.android.ui.base.model.BaseInteractor;
import com.osdb.android.ui.forgot_password.ForgotPasswordBean;
import io.reactivex.Observable;
import retrofit2.Response;

public interface ForgotPasswordInteractor extends BaseInteractor {

    Observable<Response<ForgotPasswordBean>>  getEmailResetLink(String email);
}

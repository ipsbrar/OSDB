package com.elintminds.osdb.ui.forgot_password.model;

import com.elintminds.osdb.ui.base.model.BaseInteractor;
import com.elintminds.osdb.ui.forgot_password.ForgotPasswordBean;
import io.reactivex.Observable;
import retrofit2.Response;

public interface ForgotPasswordInteractor extends BaseInteractor {

    Observable<Response<ForgotPasswordBean>>  getEmailResetLink(String email);
}

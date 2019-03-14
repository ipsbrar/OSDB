package com.elintminds.osdb.ui.forgot_password.model;

import com.elintminds.osdb.ui.base.model.BaseInteractor;
import com.elintminds.osdb.ui.forgot_password.ForgotPasswordBean;
import io.reactivex.Observable;

public interface ForgotPasswordInteractor extends BaseInteractor {

    Observable<ForgotPasswordBean>  getEmailResetLink(String email);
}

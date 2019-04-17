package com.osdb.app.ui.settings.model;

import com.osdb.app.ui.base.model.BaseInteractor;
import io.reactivex.Observable;
import org.json.JSONObject;
import retrofit2.Response;

public interface ChangePasswordInteractor extends BaseInteractor {
    Observable<Response<JSONObject>> ChangePassword(String id, String oldPassword, String password, String confirmPassword);
}

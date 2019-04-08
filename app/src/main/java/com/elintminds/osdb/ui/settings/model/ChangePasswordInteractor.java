package com.elintminds.osdb.ui.settings.model;

import com.elintminds.osdb.ui.base.model.BaseInteractor;
import io.reactivex.Observable;
import org.json.JSONObject;
import retrofit2.Response;

public interface ChangePasswordInteractor extends BaseInteractor {
    Observable<Response<JSONObject>> ChangePassword(String id, String oldPassword, String password, String confirmPassword);
}

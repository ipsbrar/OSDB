package com.osdb.app.ui.settings.model;

import android.content.Context;
import com.osdb.app.data.app_prefs.PreferenceHelper;
import com.osdb.app.ui.base.model.BaseInteractorClass;
import io.reactivex.Observable;
import org.json.JSONObject;
import retrofit2.Response;

public class ChangePasswordInteractorClass extends BaseInteractorClass implements ChangePasswordInteractor {
    public ChangePasswordInteractorClass(PreferenceHelper prefHelper, Context context) {
        super(prefHelper, context);
    }

    @Override
    public Observable<Response<JSONObject>> ChangePassword(String id, String oldPassword, String password, String confirmPassword) {
        return getApiInterface().ChangePassword(id, oldPassword, password, confirmPassword);
    }
}

package com.osdb.app.ui.edit_profile.model;

import com.google.gson.JsonElement;
import com.osdb.app.ui.base.model.BaseInteractor;
import io.reactivex.Observable;
import retrofit2.Response;

public interface EditProfileInteractor extends BaseInteractor {
    Observable<Response<JsonElement>> updateUserValue(String name,String phoneNumber,String filePath);
}

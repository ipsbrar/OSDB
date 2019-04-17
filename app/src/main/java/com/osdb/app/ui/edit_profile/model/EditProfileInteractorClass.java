package com.osdb.app.ui.edit_profile.model;

import android.content.Context;
import com.google.gson.JsonElement;
import com.osdb.app.data.app_prefs.PreferenceHelper;
import com.osdb.app.ui.base.model.BaseInteractorClass;
import io.reactivex.Observable;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Response;

import java.io.File;

public class EditProfileInteractorClass extends BaseInteractorClass implements EditProfileInteractor
{
    public EditProfileInteractorClass(PreferenceHelper prefHelper, Context context)
    {
        super(prefHelper, context);
    }

    @Override
    public Observable<Response<JsonElement>> updateUserValue(String name, String phoneNumber, String filePath) {

        return getApiInterface().updateUserData(createRequestBody(name),createRequestBody(phoneNumber),createMultipartBody(filePath));
    }
    // -- 3 --
    private MultipartBody.Part createMultipartBody(String filePath) {
        File file = new File(filePath); // -- 1 --
        RequestBody requestBody = createRequestBody(file);
        return MultipartBody.Part.createFormData("upload", file.getName(), requestBody);
    }

    // -- 2 --
    private RequestBody createRequestBody(File file) {
        return RequestBody.create(MediaType.parse("image/*"), file);
    }

    private RequestBody createRequestBody(String text){
        return     RequestBody.create(MediaType.parse("text/plain"), text);

    }
}

package com.osdb.pro.ui.dashboard.model;

import android.content.Context;
import com.osdb.pro.data.app_prefs.PreferenceHelper;
import com.osdb.pro.ui.base.model.BaseInteractorClass;
import com.osdb.pro.ui.dashboard.beans.*;
import com.google.gson.JsonElement;
import io.reactivex.Observable;
import retrofit2.Response;

public class HomeFragmentInteractorClass extends BaseInteractorClass implements HomeFragmentInteractor {

    public HomeFragmentInteractorClass(PreferenceHelper prefHelper, Context context) {
        super(prefHelper, context);
    }

    @Override
    public Observable<HomeBean> getAllHomeList(String currentDate) {
        return getApiInterface().fetchHomeData(currentDate);
    }

    @Override
    public Observable<Response<JsonElement>> AddPollsComment(String pollId, String optionId) {
        return getApiInterface().AddPollComment(pollId,optionId);
    }
}

package com.elintminds.osdb.ui.dashboard.model;

import android.content.Context;
import com.elintminds.osdb.data.app_prefs.PreferenceHelper;
import com.elintminds.osdb.ui.base.model.BaseInteractorClass;
import com.elintminds.osdb.ui.dashboard.beans.*;
import com.google.gson.JsonElement;
import io.reactivex.Observable;
import org.json.JSONObject;
import retrofit2.Response;

import java.util.ArrayList;

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

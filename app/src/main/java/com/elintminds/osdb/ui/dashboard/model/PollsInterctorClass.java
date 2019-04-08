package com.elintminds.osdb.ui.dashboard.model;

import android.content.Context;
import com.elintminds.osdb.data.app_prefs.PreferenceHelper;
import com.elintminds.osdb.ui.base.model.BaseInteractorClass;
import com.elintminds.osdb.ui.dashboard.beans.PollAdapterBean;
import com.google.gson.JsonElement;
import io.reactivex.Observable;
import org.json.JSONObject;
import retrofit2.Response;

import java.util.ArrayList;

public class PollsInterctorClass extends BaseInteractorClass implements PollsInteractor {


    public PollsInterctorClass(PreferenceHelper prefHelper, Context context) {
        super(prefHelper, context);
    }

    @Override
    public Observable<Response<ArrayList<PollAdapterBean>>> getPollsDataList(String currDate, String userId) {
        return getApiInterface().fetchPollsList(currDate,userId);
    }

    @Override
    public Observable<Response<JsonElement>> AddPollsComment(String pollId, String optionId) {
        return getApiInterface().AddPollComment(pollId,optionId);
    }
}

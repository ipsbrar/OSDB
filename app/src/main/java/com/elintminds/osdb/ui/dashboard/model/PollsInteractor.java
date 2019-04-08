package com.elintminds.osdb.ui.dashboard.model;

import com.elintminds.osdb.ui.base.model.BaseInteractor;
import com.elintminds.osdb.ui.dashboard.beans.PollAdapterBean;
import com.google.gson.JsonElement;
import io.reactivex.Observable;
import org.json.JSONObject;
import retrofit2.Response;

import java.util.ArrayList;

public interface PollsInteractor extends BaseInteractor {

    Observable<Response<ArrayList<PollAdapterBean>>> getPollsDataList(String currDate, String userId);
    Observable<Response<JsonElement>> AddPollsComment(String pollId, String optionId);
}

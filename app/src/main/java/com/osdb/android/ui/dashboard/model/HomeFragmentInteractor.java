package com.osdb.android.ui.dashboard.model;

import com.osdb.android.ui.base.model.BaseInteractor;
import com.osdb.android.ui.dashboard.beans.*;
import com.google.gson.JsonElement;
import io.reactivex.Observable;
import retrofit2.Response;

public interface HomeFragmentInteractor extends BaseInteractor
{
    Observable<HomeBean> getAllHomeList(String currentDate);
    Observable<Response<JsonElement>> AddPollsComment(String pollId, String optionId);
}

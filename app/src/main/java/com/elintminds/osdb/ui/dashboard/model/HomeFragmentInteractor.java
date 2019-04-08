package com.elintminds.osdb.ui.dashboard.model;

import com.elintminds.osdb.ui.base.model.BaseInteractor;
import com.elintminds.osdb.ui.dashboard.beans.*;
import com.google.gson.JsonElement;
import io.reactivex.Observable;
import org.json.JSONObject;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.ArrayList;

public interface HomeFragmentInteractor extends BaseInteractor
{
    Observable<ArrayList<SportsAdapterListBean>> getAllSportsList();
    Observable<HomeBean> getAllHomeList(String currentDate);
    Observable<ArrayList<BornTodayAdapterBean>> getBornTodayList(String currentDate, String limit);
    Observable<NewsAdapterBean> getAllNewsList();
    Observable<ArrayList<DoYouKnow>> getDoYouKnow();
    Observable<Response<JsonElement>> AddPollsComment(String pollId, String optionId);
}

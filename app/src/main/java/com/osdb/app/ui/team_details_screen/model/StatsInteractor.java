package com.osdb.app.ui.team_details_screen.model;

import com.osdb.app.ui.base.model.BaseInteractor;
import com.google.gson.JsonElement;
import io.reactivex.Observable;
import retrofit2.Response;

public interface StatsInteractor extends BaseInteractor {
    Observable<Response<JsonElement>> fetchTeamsStats(String teamId);
}

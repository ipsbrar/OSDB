package com.osdb.android.ui.team_details_screen.model;

import com.osdb.android.ui.base.model.BaseInteractor;
import com.osdb.android.ui.team_details_screen.beans.TeamPlayersBean;
import com.google.gson.JsonElement;
import io.reactivex.Observable;
import retrofit2.Response;

public interface TeamDetailsInteractor extends BaseInteractor {
    Observable<TeamPlayersBean> fetchAllPlayers(String teamId);
    Observable<Response<JsonElement>> fetchTeamData(String teamId);
}

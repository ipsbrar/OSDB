package com.elintminds.osdb.ui.team_details_screen.model;

import android.content.Context;
import com.elintminds.osdb.data.app_prefs.PreferenceHelper;
import com.elintminds.osdb.ui.base.model.BaseInteractorClass;
import com.elintminds.osdb.ui.team_details_screen.beans.TeamPlayersBean;
import com.google.gson.JsonElement;
import io.reactivex.Observable;
import retrofit2.Response;

public class TeamDetailsInteractorClass extends BaseInteractorClass implements TeamDetailsInteractor
{
    public TeamDetailsInteractorClass(PreferenceHelper prefHelper, Context context)
    {
        super(prefHelper, context);
    }

    @Override
    public Observable<TeamPlayersBean> fetchAllPlayers(String teamId) {
        return getApiInterface().fetchAllTeamPlayers(teamId);
    }

    @Override
    public Observable<Response<JsonElement>> fetchTeamData(String teamId) {
        return getApiInterface().fetchTeamData(teamId);
    }
}

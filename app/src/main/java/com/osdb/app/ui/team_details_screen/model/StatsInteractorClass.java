package com.osdb.app.ui.team_details_screen.model;

import android.content.Context;
import com.osdb.app.data.app_prefs.PreferenceHelper;
import com.osdb.app.ui.base.model.BaseInteractorClass;
import com.google.gson.JsonElement;
import io.reactivex.Observable;
import retrofit2.Response;

public class StatsInteractorClass extends BaseInteractorClass implements StatsInteractor{

    public StatsInteractorClass(PreferenceHelper prefHelper, Context context) {
        super(prefHelper, context);
    }

    @Override
    public Observable<Response<JsonElement>> fetchTeamsStats(String teamId) {
        return getApiInterface().fetchTeamStats(teamId);
    }
}

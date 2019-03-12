package com.elintminds.osdb.ui.team_details_screen.model;

import android.content.Context;
import com.elintminds.osdb.data.app_prefs.PreferenceHelper;
import com.elintminds.osdb.ui.base.model.BaseInteractorClass;
import com.elintminds.osdb.ui.team_details_screen.beans.TeamPlayersBean;
import io.reactivex.Observable;

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
}

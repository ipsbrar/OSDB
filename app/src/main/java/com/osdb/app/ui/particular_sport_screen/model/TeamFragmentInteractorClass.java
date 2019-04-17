package com.osdb.app.ui.particular_sport_screen.model;

import android.content.Context;
import com.osdb.app.data.app_prefs.PreferenceHelper;
import com.osdb.app.ui.base.model.BaseInteractorClass;
import com.osdb.app.ui.particular_sport_screen.beans.TeamInfoBean;
import io.reactivex.Observable;

public class TeamFragmentInteractorClass extends BaseInteractorClass implements TeamFragmentInteractor {
    public TeamFragmentInteractorClass(PreferenceHelper prefHelper, Context context) {
        super(prefHelper, context);
    }


    @Override
    public Observable<TeamInfoBean> getTeamList(String slugName) {
        return getApiInterface().fetchAllTeams(slugName);
    }
}
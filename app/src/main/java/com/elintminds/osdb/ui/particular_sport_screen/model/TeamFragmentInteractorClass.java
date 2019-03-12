package com.elintminds.osdb.ui.particular_sport_screen.model;

import android.content.Context;
import com.elintminds.osdb.data.app_prefs.PreferenceHelper;
import com.elintminds.osdb.ui.base.model.BaseInteractorClass;
import com.elintminds.osdb.ui.particular_sport_screen.beans.TeamInfoBean;
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
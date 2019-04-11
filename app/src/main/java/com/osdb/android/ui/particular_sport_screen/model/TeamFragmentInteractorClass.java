package com.osdb.android.ui.particular_sport_screen.model;

import android.content.Context;
import com.osdb.android.data.app_prefs.PreferenceHelper;
import com.osdb.android.ui.base.model.BaseInteractorClass;
import com.osdb.android.ui.particular_sport_screen.beans.TeamInfoBean;
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
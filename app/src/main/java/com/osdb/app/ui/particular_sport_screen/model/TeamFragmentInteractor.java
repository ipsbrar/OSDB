package com.osdb.app.ui.particular_sport_screen.model;

import com.osdb.app.ui.base.model.BaseInteractor;
import com.osdb.app.ui.particular_sport_screen.beans.TeamInfoBean;
import io.reactivex.Observable;


public interface TeamFragmentInteractor extends BaseInteractor {

    Observable<TeamInfoBean> getTeamList(String slugName);
}

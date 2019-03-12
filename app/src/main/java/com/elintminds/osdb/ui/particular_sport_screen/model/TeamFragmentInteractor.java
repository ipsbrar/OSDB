package com.elintminds.osdb.ui.particular_sport_screen.model;

import com.elintminds.osdb.ui.base.model.BaseInteractor;
import com.elintminds.osdb.ui.particular_sport_screen.beans.TeamInfoBean;
import io.reactivex.Observable;


public interface TeamFragmentInteractor extends BaseInteractor {

    Observable<TeamInfoBean> getTeamList(String slugName);
}

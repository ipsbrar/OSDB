package com.osdb.android.ui.particular_sport_screen.model;

import com.osdb.android.ui.base.model.BaseInteractor;
import com.osdb.android.ui.particular_sport_screen.beans.TeamInfoBean;
import io.reactivex.Observable;


public interface TeamFragmentInteractor extends BaseInteractor {

    Observable<TeamInfoBean> getTeamList(String slugName);
}

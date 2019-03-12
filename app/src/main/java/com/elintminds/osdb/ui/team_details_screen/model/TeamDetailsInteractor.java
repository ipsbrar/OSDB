package com.elintminds.osdb.ui.team_details_screen.model;

import com.elintminds.osdb.ui.base.model.BaseInteractor;
import com.elintminds.osdb.ui.team_details_screen.beans.TeamPlayersBean;
import io.reactivex.Observable;

public interface TeamDetailsInteractor extends BaseInteractor {
    Observable<TeamPlayersBean> fetchAllPlayers(String teamId);
}

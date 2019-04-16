package com.osdb.pro.ui.team_details_screen.presenter;

import com.osdb.pro.ui.base.presenter.BasePresenter;
import com.osdb.pro.ui.team_details_screen.model.TeamDetailsInteractor;
import com.osdb.pro.ui.team_details_screen.view.TeamDetailsView;

public interface TeamDetailsPresenter<V extends TeamDetailsView.TeamPlayersView, I extends TeamDetailsInteractor> extends BasePresenter<V, I>
{
    void getTeamID(String teamId);

}

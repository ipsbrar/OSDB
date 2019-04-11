package com.osdb.android.ui.team_details_screen.presenter;

import com.osdb.android.ui.base.presenter.BasePresenter;
import com.osdb.android.ui.team_details_screen.model.TeamDetailsInteractor;
import com.osdb.android.ui.team_details_screen.view.TeamDetailsView;

public interface TeamDetailsPresenter<V extends TeamDetailsView.TeamPlayersView, I extends TeamDetailsInteractor> extends BasePresenter<V, I>
{
    void getTeamID(String teamId);

}

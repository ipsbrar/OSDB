package com.osdb.android.ui.team_details_screen.presenter;

import com.osdb.android.ui.base.presenter.BasePresenter;
import com.osdb.android.ui.team_details_screen.model.TeamDetailsInteractor;
import com.osdb.android.ui.team_details_screen.view.TeamDetailsView;

public interface TeamDetail<V extends TeamDetailsView, I extends TeamDetailsInteractor> extends BasePresenter<V, I>
{
    void getTeamData(String teamData);

}

package com.osdb.app.ui.team_details_screen.presenter;

import com.osdb.app.ui.base.presenter.BasePresenter;
import com.osdb.app.ui.team_details_screen.model.StatsInteractor;
import com.osdb.app.ui.team_details_screen.view.StatsView;

public interface StatsPresenter <V extends StatsView, I extends StatsInteractor> extends BasePresenter<V, I>
{
  void fetchTeamStatsData(String teamId);
}
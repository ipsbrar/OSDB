package com.osdb.android.ui.team_details_screen.presenter;

import com.osdb.android.ui.base.presenter.BasePresenter;
import com.osdb.android.ui.team_details_screen.model.StatsInteractor;
import com.osdb.android.ui.team_details_screen.view.StatsView;

public interface StatsPresenter <V extends StatsView, I extends StatsInteractor> extends BasePresenter<V, I>
{
  void fetchTeamStatsData(String teamId);
}
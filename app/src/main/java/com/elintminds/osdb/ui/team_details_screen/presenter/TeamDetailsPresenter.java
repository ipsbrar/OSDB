package com.elintminds.osdb.ui.team_details_screen.presenter;

import com.elintminds.osdb.ui.base.presenter.BasePresenter;
import com.elintminds.osdb.ui.team_details_screen.model.TeamDetailsInteractor;
import com.elintminds.osdb.ui.team_details_screen.view.TeamDetailsView;

public interface TeamDetailsPresenter<V extends TeamDetailsView, I extends TeamDetailsInteractor> extends BasePresenter<V, I>
{
}

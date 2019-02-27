package com.elintminds.osdb.ui.player_details_screen.presenter;

import com.elintminds.osdb.ui.base.presenter.BasePresenter;
import com.elintminds.osdb.ui.player_details_screen.model.PlayerDetailsInteractor;
import com.elintminds.osdb.ui.player_details_screen.view.PlayerDetailsView;

public interface PlayerDetailsPresenter<V extends PlayerDetailsView, I extends PlayerDetailsInteractor> extends BasePresenter<V, I>
{

}
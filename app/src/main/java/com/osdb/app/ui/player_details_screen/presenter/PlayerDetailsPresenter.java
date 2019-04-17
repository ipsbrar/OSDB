package com.osdb.app.ui.player_details_screen.presenter;

import android.content.Context;
import com.osdb.app.ui.base.presenter.BasePresenter;
import com.osdb.app.ui.player_details_screen.model.PlayerDetailsInteractor;
import com.osdb.app.ui.player_details_screen.view.PlayerDetailsView;

public interface PlayerDetailsPresenter<V extends PlayerDetailsView, I extends PlayerDetailsInteractor> extends BasePresenter<V, I>
{
    void giveDate(String stringDate);

    void getPlayerID(String playerID, Context context, String token);
}

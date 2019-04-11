package com.osdb.android.ui.player_details_screen.presenter;

import android.content.Context;
import com.osdb.android.ui.base.presenter.BasePresenter;
import com.osdb.android.ui.player_details_screen.model.PlayerDetailsInteractor;
import com.osdb.android.ui.player_details_screen.view.PlayerDetailsView;

public interface PlayerDetailsPresenter<V extends PlayerDetailsView, I extends PlayerDetailsInteractor> extends BasePresenter<V, I>
{
    void giveDate(String stringDate);

    void getPlayerID(String playerID, Context context, String token);
}

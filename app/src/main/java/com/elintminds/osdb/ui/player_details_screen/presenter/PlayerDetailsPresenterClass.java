package com.elintminds.osdb.ui.player_details_screen.presenter;

import android.content.Context;
import com.elintminds.osdb.data.app_prefs.AppPreferenceHelperClass;
import com.elintminds.osdb.ui.base.presenter.BasePresenterClass;
import com.elintminds.osdb.ui.player_details_screen.model.PlayerDetailsInteractor;
import com.elintminds.osdb.ui.player_details_screen.model.PlayerDetailsInteractorClass;
import com.elintminds.osdb.ui.player_details_screen.view.PlayerDetailsView;

public class PlayerDetailsPresenterClass<V extends PlayerDetailsView, I extends PlayerDetailsInteractor>
        extends BasePresenterClass<V, I> implements PlayerDetailsPresenter<V, I>
{
    private PlayerDetailsPresenterClass(Context context, I interactor, V view)
    {
        super(context, interactor, view);
    }

    public PlayerDetailsPresenterClass(Context context, V view)
    {
        this(context, (I) new PlayerDetailsInteractorClass(new AppPreferenceHelperClass(context), context), view);
    }
}

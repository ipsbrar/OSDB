package com.elintminds.osdb.ui.team_details_screen.presenter;

import android.content.Context;
import com.elintminds.osdb.data.app_prefs.AppPreferenceHelperClass;
import com.elintminds.osdb.ui.base.presenter.BasePresenterClass;
import com.elintminds.osdb.ui.team_details_screen.model.TeamDetailsInteractor;
import com.elintminds.osdb.ui.team_details_screen.model.TeamDetailsInteractorClass;
import com.elintminds.osdb.ui.team_details_screen.view.TeamDetailsView;

public class TeamDetailsPresenterClass<V extends TeamDetailsView, I extends TeamDetailsInteractor>
        extends BasePresenterClass<V, I> implements TeamDetailsPresenter<V, I>
{

    private TeamDetailsPresenterClass(Context context, I interactor, V view)
    {
        super(context, interactor, view);
    }

    public TeamDetailsPresenterClass(Context context, V view)
    {
        this(context, (I) new TeamDetailsInteractorClass(new AppPreferenceHelperClass(context), context), view);
    }
}

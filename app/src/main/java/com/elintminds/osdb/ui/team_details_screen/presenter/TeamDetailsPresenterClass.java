package com.elintminds.osdb.ui.team_details_screen.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.elintminds.osdb.data.app_prefs.AppPreferenceHelperClass;
import com.elintminds.osdb.ui.base.presenter.BasePresenterClass;
import com.elintminds.osdb.ui.team_details_screen.beans.TeamPlayersBean;
import com.elintminds.osdb.ui.team_details_screen.model.TeamDetailsInteractor;
import com.elintminds.osdb.ui.team_details_screen.model.TeamDetailsInteractorClass;
import com.elintminds.osdb.ui.team_details_screen.view.TeamDetailsView;
import com.elintminds.osdb.utils.ConnectivityReceiver;
import io.reactivex.functions.Consumer;

public class TeamDetailsPresenterClass<V extends TeamDetailsView.TeamPlayersView, I extends TeamDetailsInteractor>
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

    @Override
    public void getTeamID(String teamId) {
        if (ConnectivityReceiver.isConnected()) {
            getMvpView().showProgressDialog();
            Log.e("HomeSwipeData", "   Inside Presenter");
            getCompositeDisposable().add(getInteractor()
                    .fetchAllPlayers(teamId)
                    .subscribeOn(getSchedulerProvider().io())
                    .observeOn(getSchedulerProvider().ui())
                    .subscribe(new Consumer<TeamPlayersBean>() {
                                   @Override
                                   public void accept(TeamPlayersBean teamPlayersBean) throws Exception {
                                       Log.e("HomeSwipeData", "   Inside Success");
                                       getMvpView().getPlayers(teamPlayersBean);
                                       getMvpView().hideProgressDialog();
                                   }
                               },
                            new Consumer<Throwable>() {
                                @Override
                                public void accept(Throwable throwable) throws Exception {
                                    Log.e("HomeSwipeData", "   Inside Reject");
                                    getMvpView().getError(throwable.toString());
                                    getMvpView().hideProgressDialog();
                                }
                            }));
        }else{
            getMvpView().getError("No internet found");
        }
    }
}

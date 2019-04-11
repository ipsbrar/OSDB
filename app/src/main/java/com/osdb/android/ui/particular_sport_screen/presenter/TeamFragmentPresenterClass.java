package com.osdb.android.ui.particular_sport_screen.presenter;

import android.content.Context;
import android.util.Log;
import com.osdb.android.data.app_prefs.AppPreferenceHelperClass;
import com.osdb.android.ui.base.presenter.BasePresenterClass;
import com.osdb.android.ui.particular_sport_screen.beans.TeamClubBean;
import com.osdb.android.ui.particular_sport_screen.beans.TeamInfoBean;
import com.osdb.android.ui.particular_sport_screen.model.TeamFragmentInteractor;
import com.osdb.android.ui.particular_sport_screen.model.TeamFragmentInteractorClass;
import com.osdb.android.ui.particular_sport_screen.view.TeamFragmentView;
import com.osdb.android.utils.ConnectivityReceiver;
import io.reactivex.functions.Consumer;

import java.util.ArrayList;

public class TeamFragmentPresenterClass<V extends TeamFragmentView, I extends TeamFragmentInteractor>
        extends BasePresenterClass<V, I> implements TeamFragmentPresenter<V, I> {
    private TeamFragmentPresenterClass(Context context, I interactor, V view) {
        super(context, interactor, view);
    }

    public TeamFragmentPresenterClass(Context context, V view) {
        this(context, (I) new TeamFragmentInteractorClass(new AppPreferenceHelperClass(context), context), view);
    }

    @Override
    public void getSlugName(String slugName) {
        if (ConnectivityReceiver.isConnected()) {
            getMvpView().showProgressDialog();
            Log.e("HomeSwipeData", "   Inside Presenter");
            getCompositeDisposable().add(getInteractor()
                    .getTeamList(slugName)
                    .subscribeOn(getSchedulerProvider().io())
                    .observeOn(getSchedulerProvider().ui())
                    .subscribe(new Consumer<TeamInfoBean>() {
                                   @Override
                                   public void accept(TeamInfoBean teamInfoBean) throws Exception {

                                       ArrayList<TeamClubBean> teamClubBeans = new ArrayList<>();

                                       if (teamInfoBean.getTeams() != null && teamInfoBean.getTeams().size() > 0) {

                                           for (int i = 0; i < teamInfoBean.getTeams().size(); i++) {
                                               boolean isFound = false;
                                               for (int j = 0; j < teamClubBeans.size(); j++) {
                                                   if (teamClubBeans.get(j).getTeamClubName().equalsIgnoreCase(teamInfoBean.getTeams().get(i).getDivision().getName())) {
                                                       isFound = true;
                                                       teamClubBeans.get(j).getTeamsList().add(teamInfoBean.getTeams().get(i));
                                                       break;
                                                   }

                                               }
                                               if (!isFound) {
                                                   TeamClubBean teamClubBean = new TeamClubBean();
                                                   teamClubBean.setTeamClubName(teamInfoBean.getTeams().get(i).getDivision().getName());
                                                   teamClubBean.setItemInList(teamInfoBean.getTeams().get(i));
                                                   teamClubBeans.add(teamClubBean);
                                               }
                                           }

                                       }
                                       getMvpView().getAllListsOfTeam(teamClubBeans);
                                       getMvpView().hideProgressDialog();
                                   }
                               },
                            new Consumer<Throwable>() {
                                @Override
                                public void accept(Throwable throwable) throws Exception {
                                    getMvpView().getError(throwable.toString());
                                    getMvpView().hideProgressDialog();
                                }
                            }));
        }else{
            getMvpView().getError("Not internet found");
        }
    }
}

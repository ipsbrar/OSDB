package com.osdb.pro.ui.search_finding_screen.presenter;

import android.content.Context;
import android.util.Log;
import com.osdb.pro.data.app_prefs.AppPreferenceHelperClass;
import com.osdb.pro.ui.base.presenter.BasePresenterClass;
import com.osdb.pro.ui.search_finding_screen.beans.ScheduleBean;
import com.osdb.pro.ui.search_finding_screen.beans.ScheduleBeans;
import com.osdb.pro.ui.search_finding_screen.model.ScheduleFragmentInteractor;
import com.osdb.pro.ui.search_finding_screen.model.ScheduleFragmentInteractorClass;
import com.osdb.pro.ui.search_finding_screen.view.ScheduleFragmentView;
import com.osdb.pro.utils.ConnectivityReceiver;
import com.osdb.pro.utils.Utils;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

import java.util.ArrayList;

public class ScheduleFragmentPresenterClass<V extends ScheduleFragmentView, I extends ScheduleFragmentInteractor>
        extends BasePresenterClass<V, I> implements ScheduleFragmentPresenter<V, I> {
    private ScheduleFragmentPresenterClass(Context context, I interactor, V view) {
        super(context, interactor, view);
    }

    public ScheduleFragmentPresenterClass(Context context, V view) {
        this(context, (I) new ScheduleFragmentInteractorClass(new AppPreferenceHelperClass(context), context), view);
    }

    @Override
    public void getSlugName(String slug,String year,String session) {
        if (ConnectivityReceiver.isConnected()) {
            getMvpView().showProgressDialog();
            Log.e("HomeSwipeData", "   Inside Presenter");
            getCompositeDisposable().add(getInteractor()
                    .fetchSchedules(slug,year,session)
                    .subscribeOn(getSchedulerProvider().io())
                    .observeOn(getSchedulerProvider().ui())
                    .subscribe(new Consumer<ScheduleBeans>() {
                                   @Override
                                   public void accept(ScheduleBeans scheduleBeans) throws Exception {
                                       ArrayList<ScheduleBean> allSchedule = new ArrayList<>();
                                       String vanueName = "", vanueCity = "", vanueState = "", vanueCountry = "";
                                       for (int i = 0; i < scheduleBeans.getSchedules().size(); i++) {

                                           for (int j = 0; j < scheduleBeans.getSchedules().get(i).getGames().size(); j++) {
                                               ScheduleBean scheduleBean = new ScheduleBean();
                                               if (scheduleBeans.getSchedules().get(i).getGames().get(j).getVenue() != null) {
                                                   JSONObject jsonObject = new JSONObject(scheduleBeans.getSchedules().get(i).getGames().get(j).getVenue());
                                                   vanueName = jsonObject.has("name") ? jsonObject.getString("name") : "";
                                                   vanueCity = jsonObject.has("city") ? jsonObject.getString("city") : "";
                                                   vanueState = jsonObject.has("state") ? jsonObject.getString("state") : "";
                                                   vanueCountry = jsonObject.has("country") ? jsonObject.getString("country") : "";
                                               }
                                               String matchAddress = vanueName + " " + vanueCity + " " + vanueState + " " + vanueCountry;
                                               String eventTime = scheduleBeans.getSchedules().get(i).getGames().get(j).getScheduledDateTime();
                                               String matchTiming = eventTime != null ? Utils.getFormatedDate(eventTime,"yyyy-MM-dd hh:mm:ss","h:mm a") : "none";
                                               scheduleBean.setMatchAddres(matchAddress);
                                               scheduleBean.setMatchTime(matchTiming);

                                               for (int k = 0; k < scheduleBeans.getSchedules().get(i).getGames().get(j).getParticipants().size(); k++) {
                                                   if (k == 0) {
                                                       String teamOneName = scheduleBeans.getSchedules().get(i).getGames().get(j).getParticipants().get(k).getTeams().getTeamName();
                                                       String teamOneLogo = scheduleBeans.getSchedules().get(i).getGames().get(j).getParticipants().get(k).getTeams().getLogo();
                                                       scheduleBean.setTeamOneName(teamOneName);
                                                       scheduleBean.setTeamOneLogo(teamOneLogo);
                                                   } else if (k == 1) {
                                                       String teamTwoName = scheduleBeans.getSchedules().get(i).getGames().get(j).getParticipants().get(k).getTeams().getTeamName();
                                                       String teamTwoLogo = scheduleBeans.getSchedules().get(i).getGames().get(j).getParticipants().get(k).getTeams().getLogo();
                                                       scheduleBean.setTeamTwoName(teamTwoName);
                                                       scheduleBean.setTeamTwoLogo(teamTwoLogo);
                                                   }
                                               }
                                               allSchedule.add(scheduleBean);
                                           }
                                       }

                                       getMvpView().success(allSchedule);
                                       getMvpView().hideProgressDialog();
                                   }
                               },
                            new Consumer<Throwable>() {
                                @Override
                                public void accept(Throwable throwable) throws Exception {
                                    getMvpView().error(throwable.toString());
                                    getMvpView().hideProgressDialog();
                                }
                            }));
        } else {
            getMvpView().error("No internet found");
        }
    }
}

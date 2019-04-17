package com.osdb.app.ui.team_details_screen.presenter;

import android.content.Context;
import android.util.Log;
import com.osdb.app.data.app_prefs.AppPreferenceHelperClass;
import com.osdb.app.ui.base.presenter.BasePresenterClass;
import com.osdb.app.ui.team_details_screen.model.TeamDetailsInteractor;
import com.osdb.app.ui.team_details_screen.model.TeamDetailsInteractorClass;
import com.osdb.app.ui.team_details_screen.view.TeamDetailsView;
import com.osdb.app.utils.ConnectivityReceiver;
import com.google.gson.JsonElement;
import io.reactivex.functions.Consumer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Response;

public class TeamDetailPresenterActivity<V extends TeamDetailsView, I extends TeamDetailsInteractor>
        extends BasePresenterClass<V, I> implements TeamDetail<V, I> {

    private TeamDetailPresenterActivity(Context context, I interactor, V view) {
        super(context, interactor, view);
    }

    public TeamDetailPresenterActivity(Context context, V view) {
        this(context, (I) new TeamDetailsInteractorClass(new AppPreferenceHelperClass(context), context), view);
    }


    @Override
    public void getTeamData(String teamData) {
        if (ConnectivityReceiver.isConnected()) {
            getMvpView().showProgressDialog();
            Log.e("HomeSwipeData", "   Inside Presenter");
            getCompositeDisposable().add(getInteractor()
                    .fetchTeamData(teamData)
                    .subscribeOn(getSchedulerProvider().io())
                    .observeOn(getSchedulerProvider().ui())
                    .subscribe(new Consumer<Response<JsonElement>>() {
                                   @Override
                                   public void accept(Response<JsonElement> response) throws Exception {
                                       Log.e("HomeSwipeData", "   Inside Success");
                                       if (response.isSuccessful()) {
                                           parseTeamData(response.body().toString());
                                       }
                                       getMvpView().hideProgressDialog();
                                   }
                               },
                            new Consumer<Throwable>() {
                                @Override
                                public void accept(Throwable throwable) throws Exception {
                                    Log.e("HomeSwipeData", "   Inside Reject");
                                    getMvpView().getError(throwable.toString(), false);
                                    getMvpView().hideProgressDialog();
                                }
                            }));
        } else {
            getMvpView().getError("No internet found", false);
        }
    }

    private void parseTeamData(String toString) {
        String coachName = null, vanueName = null,city = null;
        try {
            JSONObject jsonObject = new JSONObject(toString);
            if (jsonObject.has("coaches")) {
                String coaches = jsonObject.getString("coaches");
                JSONArray coachArray = new JSONArray(coaches);
                for (int i = 0; i < coachArray.length(); i++) {
                    JSONObject coachObj = coachArray.getJSONObject(i);
                    if (coachName == null)
                        coachName = coachObj.getString("full_name");
                    else
                        coachName = coachName + ", " + coachObj.getString("full_name");
                }
//                coachName = coachObj.getString("full_name");
            }

            if (jsonObject.has("venue")) {

                JSONObject vanueObj = new JSONObject(jsonObject.getString("venue"));
                vanueName = vanueObj.getString("name");
                city = vanueObj.getString("city");
            }
            getMvpView().TeamData(coachName, vanueName+", "+city);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

package com.elintminds.osdb.ui.dashboard.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.elintminds.osdb.data.app_prefs.AppPreferenceHelperClass;
import com.elintminds.osdb.ui.base.presenter.BasePresenterClass;
import com.elintminds.osdb.ui.dashboard.beans.PollAdapterBean;
import com.elintminds.osdb.ui.dashboard.model.PollsInteractor;
import com.elintminds.osdb.ui.dashboard.model.PollsInterctorClass;
import com.elintminds.osdb.ui.dashboard.view.PollView;
import com.elintminds.osdb.utils.ConnectivityReceiver;
import com.google.gson.JsonElement;
import io.reactivex.functions.Consumer;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PollsPresenterClass<V extends PollView, I extends PollsInteractor>
        extends BasePresenterClass<V, I> implements PollsPresenter<V, I> {
    public PollsPresenterClass(Context context, I interactor, V view) {
        super(context, interactor, view);
    }

    public PollsPresenterClass(Context context, V view) {
        this(context, (I) new PollsInterctorClass(new AppPreferenceHelperClass(context), context), view);
    }

    @Override
    public void getPollsData(String currentDate, String userId) {
        if (ConnectivityReceiver.isConnected()) {
            getCompositeDisposable().add(getInteractor()
                    .getPollsDataList(currentDate, userId)
                    .subscribeOn(getSchedulerProvider().io())
                    .observeOn(getSchedulerProvider().ui())
                    .subscribe(new Consumer<Response<ArrayList<PollAdapterBean>>>() {
                                   @Override
                                   public void accept(Response<ArrayList<PollAdapterBean>> pollList) throws Exception {
                                       if (pollList.isSuccessful()){
                                           getMvpView().getPollData(pollList.body());
                                       } else {
                                           getMvpView().error("No data found", true);
                                       }

                                   }
                               },
                            new Consumer<Throwable>() {
                                @Override
                                public void accept(Throwable throwable) throws Exception {
                                    Log.e("PollData", "Error=======    " + throwable.toString());
                                    getMvpView().error(throwable.toString(), true);
                                }
                            }));

        } else {
            getMvpView().error("No internet found", true);
        }
    }

    @Override
    public void VotePolls(final Context context, String pollId, String optionId, final String token) {

        if (ConnectivityReceiver.isConnected()) {
            getMvpView().showProgressDialog();
            getCompositeDisposable().add(getInteractor()
                    .AddPollsComment(pollId, optionId)
                    .subscribeOn(getSchedulerProvider().io())
                    .observeOn(getSchedulerProvider().ui())
                    .subscribe(new Consumer<Response<JsonElement>>() {
                                   @Override
                                   public void accept(Response<JsonElement> response) throws Exception {
                                       if (response.isSuccessful()) {
                                           getMvpView().VotePolls("Vote Successfully");
                                       } else {
                                           if (response.code() == 409) {
                                               Toast.makeText(context, "User already voted", Toast.LENGTH_SHORT).show();
                                           }
//                                           getMvpView().error(response.body().getString("error"), false);
                                       }
                                       getMvpView().hideProgressDialog();
                                   }
                               },
                            new Consumer<Throwable>() {
                                @Override
                                public void accept(Throwable throwable) throws Exception {
                                    Log.e("PollData", "Error=======    " + throwable.toString());
                                    getMvpView().error(throwable.toString(), true);
                                    getMvpView().hideProgressDialog();
                                }
                            }));

        } else {
            getMvpView().error("No internet found", true);
        }


//        if (ConnectivityReceiver.isConnected()) {
//            getMvpView().showProgressDialog();
//
//            JSONObject jsonObject = new JSONObject();
//            try {
//                jsonObject.put("poll_id", pollId);
//                jsonObject.put("poll_option_id", optionId);
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//
//            String url = "https://dev.osdb.pro:81/api/v1/polls/vote/add";
//
//
//            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject, new Response.Listener<JSONObject>() {
//                @Override
//                public void onResponse(JSONObject response) {
//                    if (response.has("poll")) {
//                        Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
//                        getMvpView().VotePolls("Vote Successfully");
//                    } else {
//                        if (response.has("error")) {
//                            try {
//                                getMvpView().error(response.getString("error"), false);
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }
//                    getMvpView().hideProgressDialog();
//                }
//            }, new Response.ErrorListener() {
//                @Override
//                public void onErrorResponse(VolleyError error) {
//                    Toast.makeText(context, "Failure", Toast.LENGTH_SHORT).show();
//                    getMvpView().error(error.toString(), false);
//                    getMvpView().hideProgressDialog();
//                }
//            }) {
//                @Override
//                public Map<String, String> getHeaders() throws AuthFailureError {
////                super.getHeaders();
//                    Map<String, String> headers = new HashMap<>();
//
//                    headers.put("Content-Type", "application/x-www-form-urlencoded");
//                    headers.put("Accept", "application/json");
////                headers.put("Authorization", "Bearer " + "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczpcL1wvc3RhZ2luZy5vc2RiLnBybzo4MVwvYXBpXC92MVwvbG9naW4iLCJpYXQiOjE1NTIzNzA2OTYsImV4cCI6MTU1MjgwMjY5NiwibmJmIjoxNTUyMzcwNjk2LCJqdGkiOiJERUpQVTN2cnZBZEIyQzZrIiwic3ViIjozNjIsInBydiI6Ijg3ZTBhZjFlZjlmZDE1ODEyZmRlYzk3MTUzYTE0ZTBiMDQ3NTQ2YWEifQ.IrSsXMjW-BWKhrfFuEMCiitdVS_ijN6bFBvfsE2_Cjk");
//                    headers.put("Authorization", "Bearer " + token);
//
//                    return headers;
//                }
//            };
//
//            Volley.newRequestQueue(context).add(jsonObjectRequest);
//        } else {
//            getMvpView().error("No internet found", true);
//        }
    }

}

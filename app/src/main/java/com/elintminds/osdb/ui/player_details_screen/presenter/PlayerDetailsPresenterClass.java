package com.elintminds.osdb.ui.player_details_screen.presenter;

import android.content.Context;
import android.util.Log;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.elintminds.osdb.data.app_prefs.AppPreferenceHelperClass;
import com.elintminds.osdb.data.network.WebserviceUrls;
import com.elintminds.osdb.ui.base.presenter.BasePresenterClass;
import com.elintminds.osdb.ui.player_details_screen.beans.PlayerDetailInfoBean;
import com.elintminds.osdb.ui.player_details_screen.model.PlayerDetailsInteractor;
import com.elintminds.osdb.ui.player_details_screen.model.PlayerDetailsInteractorClass;
import com.elintminds.osdb.ui.player_details_screen.view.PlayerDetailsView;
import org.json.JSONException;
import org.json.JSONObject;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.util.Calendar.YEAR;

public class PlayerDetailsPresenterClass<V extends PlayerDetailsView, I extends PlayerDetailsInteractor>
        extends BasePresenterClass<V, I> implements PlayerDetailsPresenter<V, I> {
    private PlayerDetailsPresenterClass(Context context, I interactor, V view) {
        super(context, interactor, view);
    }

    public PlayerDetailsPresenterClass(Context context, V view) {
        this(context, (I) new PlayerDetailsInteractorClass(new AppPreferenceHelperClass(context), context), view);
    }

    @Override
    public void giveDate(String stringDate) {

        getMvpView().formattedDate(getFormatedDate(stringDate));

        Date c = Calendar.getInstance().getTime();
        Date first = getDateFormat(stringDate);
        Date second = getDateFormat(c);
        String ageDiff = getDiffYears(first, second);


        getMvpView().playersAge(ageDiff);
    }

    @Override
    public void getPlayerID(String playerID,Context context) {
        getMvpView().showProgressDialog();
        String url = "https://staging.osdb.pro:81/api/v1/players/" + playerID;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("SuccessVoley",response);
                if (response != null)
                    parseData(response);

                getMvpView().hideProgressDialog();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("ErrorVolly",error.toString());
                getMvpView().errorOccur(error.toString());
                getMvpView().hideProgressDialog();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
//                super.getHeaders();
                Map<String, String> headers = new HashMap<>();

                headers.put("Content-Type", "application/x-www-form-urlencoded");
                headers.put("Accept", "application/json");
                headers.put("Authorization", "Bearer " + "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczpcL1wvc3RhZ2luZy5vc2RiLnBybzo4MVwvYXBpXC92MVwvbG9naW4iLCJpYXQiOjE1NTIzNzA2OTYsImV4cCI6MTU1MjgwMjY5NiwibmJmIjoxNTUyMzcwNjk2LCJqdGkiOiJERUpQVTN2cnZBZEIyQzZrIiwic3ViIjozNjIsInBydiI6Ijg3ZTBhZjFlZjlmZDE1ODEyZmRlYzk3MTUzYTE0ZTBiMDQ3NTQ2YWEifQ.IrSsXMjW-BWKhrfFuEMCiitdVS_ijN6bFBvfsE2_Cjk");
//
                return headers;
            }
        };

        Volley.newRequestQueue(context).add(stringRequest);
    }

    private void parseData(String response) {
        try {
//            pending   ==>  playerPosition,playerSportsAgent,playerTelevision,currentContract,careerHighlight
            JSONObject jsonObject = new JSONObject(response);
            String height = jsonObject.getString("height");
            String weight = jsonObject.getString("weight");
            String playerCollege = jsonObject.getString("college_university");
            String placeOfBirth = jsonObject.getString("birth_place");
            String playerPosition = jsonObject.getString("weight");
            String playerFanMailAddress = jsonObject.getString("fan_email");
            String playerSportsAgent = jsonObject.getString("weight");
            String playerTelevision = jsonObject.getString("weight");
            String currentContract = jsonObject.getString("weight");
            String businessVentures = jsonObject.getString("business_ventures");
            String endorsementDeals = jsonObject.getString("endorsement_deals");
            String communityWork = jsonObject.getString("community_works");
            String careerHighlight = jsonObject.getString("weight");

            PlayerDetailInfoBean playerDetailInfoBean = new PlayerDetailInfoBean();
            playerDetailInfoBean.setPlayerHeight(height != null ? height : "");
            playerDetailInfoBean.setPlayerWeight(weight != null ? weight : "");
            playerDetailInfoBean.setPlayerCollege(playerCollege != null ? playerCollege : "");
            playerDetailInfoBean.setPlaceOfBirth(placeOfBirth != null ? placeOfBirth : "");
            playerDetailInfoBean.setPlayerFanMailAddress(playerFanMailAddress != null ? playerFanMailAddress : "");
            playerDetailInfoBean.setPlayerPosition(playerPosition != null ? playerPosition : "");
            playerDetailInfoBean.setPlayerSportsAgent(playerSportsAgent != null ? playerSportsAgent : "");
            playerDetailInfoBean.setPlayerTelevision(playerTelevision != null ? playerTelevision : "");
            playerDetailInfoBean.setCurrentContract(currentContract != null ? currentContract : "");
            playerDetailInfoBean.setBusinessVentures(businessVentures != null ? businessVentures : "");
            playerDetailInfoBean.setEndorsementDeals(endorsementDeals != null ? endorsementDeals : "");
            playerDetailInfoBean.setCommunityWork(communityWork != null ? communityWork : "");
            playerDetailInfoBean.setCareerHighlight(careerHighlight != null ? careerHighlight : "");

            getMvpView().fetchPlayerDetailInfo(playerDetailInfoBean);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private String getFormatedDate(String rawDate) {
        DateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        DateFormat targetFormat = new SimpleDateFormat("MMM dd, yyyy");
        try {

            Date date = originalFormat.parse(rawDate);
            String formattedDate = targetFormat.format(date);
            return formattedDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    private Date getDateFormat(String rawDate) {
        DateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        try {

            Date date = originalFormat.parse(rawDate);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Date getDateFormat(Date rawDate) {
        DateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        try {

            String date = originalFormat.format(rawDate);
            Date forDate = originalFormat.parse(date);
            return forDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getDiffYears(Date first, Date last) {
        Calendar a = getCalendar(first);
        Calendar b = getCalendar(last);
        int diff = b.get(YEAR) - a.get(YEAR);
//        if (a.get(MONTH) > b.get(MONTH) ||
//                (a.get(MONTH) == b.get(MONTH) && a.get(DATE) > b.get(DATE))) {
//            diff--;
//        }
        return diff + " YEARS";
    }

    private Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTime(date);
        return cal;
    }


}

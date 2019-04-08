package com.elintminds.osdb.ui.player_details_screen.presenter;

import android.content.Context;
import android.util.Log;
import com.elintminds.osdb.data.app_prefs.AppPreferenceHelperClass;
import com.elintminds.osdb.ui.base.presenter.BasePresenterClass;
import com.elintminds.osdb.ui.player_details_screen.beans.CharityCommunityBeans;
import com.elintminds.osdb.ui.player_details_screen.beans.PlayerDetailInfoBean;
import com.elintminds.osdb.ui.player_details_screen.beans.VideosBean;
import com.elintminds.osdb.ui.player_details_screen.model.PlayerDetailsInteractor;
import com.elintminds.osdb.ui.player_details_screen.model.PlayerDetailsInteractorClass;
import com.elintminds.osdb.ui.player_details_screen.view.PlayerDetailsView;
import com.elintminds.osdb.ui.team_details_screen.beans.StatsBeans;
import com.elintminds.osdb.ui.team_details_screen.beans.StatsBeans2;
import com.elintminds.osdb.utils.ConnectivityReceiver;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import io.reactivex.functions.Consumer;
import org.json.JSONArray;
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
        String outputDate = getFormatedDate(stringDate);
        getMvpView().formattedDate(outputDate);

        Date c = Calendar.getInstance().getTime();
        Date first = getDateFormat(stringDate);
        Date second = getDateFormat(c);
        String ageDiff = getDiffYears(first, second);
//        ageDiff

        getMvpView().playersAge(getAge(outputDate));
    }


    private String getAge(String dobString) {
        DateFormat originalFormat = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        Date date = null;
        int year = 0;
        int month = 0;
        int day = 0;
        try {
            date = originalFormat.parse(dobString);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            month = cal.get(Calendar.MONTH);
            day = cal.get(Calendar.DATE);
            year = cal.get(Calendar.YEAR);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        dob.set(year, month, day);

        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }

        Integer ageInt = new Integer(age);
        String ageS = ageInt.toString();

        return ageS + " Years";
    }

    @Override
    public void getPlayerID(String playerID, Context context, final String token) {

        if (ConnectivityReceiver.isConnected()) {
            getMvpView().showProgressDialog();
            getCompositeDisposable().add(getInteractor()
                    .fetchPlayerDetail(playerID)
                    .subscribeOn(getSchedulerProvider().io())
                    .observeOn(getSchedulerProvider().ui())
                    .subscribe(new Consumer<retrofit2.Response<JsonElement>>() {
                                   @Override
                                   public void accept(retrofit2.Response<JsonElement> response) throws Exception {
                                       Log.e("HomeSwipeData", "   Inside Success");
                                       if (response.isSuccessful()) {
                                           if (response.body() != null)
                                               parseData(response.body().toString());
                                       } else {
                                           getMvpView().errorOccur("Something went wrong");
                                       }
                                       getMvpView().hideProgressDialog();
                                   }
                               },
                            new Consumer<Throwable>() {
                                @Override
                                public void accept(Throwable throwable) throws Exception {
                                    Log.e("HomeSwipeData", "   Inside Reject");
                                    getMvpView().errorOccur(throwable.toString());
                                    getMvpView().hideProgressDialog();
                                }
                            }));
        } else {
            getMvpView().errorOccur("No Internet connection");
        }


    }

    private void parseData(String response) {
        ArrayList<String> careerHeights = new ArrayList<>();
        ArrayList<String> imageListString = new ArrayList<>();
        ArrayList<VideosBean> videosBeanArrayList = new ArrayList<>();
        ArrayList<StatsBeans> statsBeansArrayList = new ArrayList<>();
        String dateOfBirth = null;
        try {
//            player info
//            pending   ==>  playerPosition,playerSportsAgent,playerTelevision,currentContract,careerHighlight
            JSONObject jsonObject = new JSONObject(response);
            dateOfBirth = jsonObject.getString("date_of_birth");
            giveDate(dateOfBirth);
            String height = jsonObject.getString("height");
            String weight = jsonObject.getString("weight");
            String playerCollege = jsonObject.getString("college_university");
            String placeOfBirth = jsonObject.getString("birth_place");

            String playerFanMailAddress = jsonObject.getString("fan_email");
            String businessVentures = jsonObject.getString("business_ventures");
            String endorsementDeals = jsonObject.getString("endorsement_deals");
            String communityWork = jsonObject.getString("community_works");
            String careerHighlight = jsonObject.getString("weight");
            String playerPosition = null;
            String jersey = null;
            String draft = null;
            if (jsonObject.has("meta")) {
                String metaString = jsonObject.getString("meta");
                JSONObject metaObj = new JSONObject(metaString);
                jersey = metaObj.getString("jersey");
                playerPosition = metaObj.getString("position");
                JSONObject draftObj = metaObj.getJSONObject("draft");
                String year = draftObj.getString("year");
                String round = draftObj.getString("round");
                String number = draftObj.getString("number");
                draft = year + "/Round " + round + "/Pick " + number;
            }
            String playerSportsAgent = null;
            String playerTelevision = null;
            String currentContract = null;
            if (jsonObject.has("agencies")) {
                JSONArray agenciesArray = jsonObject.getJSONArray("agencies");
                for (int i = 0; i < agenciesArray.length(); i++) {
                    JSONObject agenciesObj = agenciesArray.getJSONObject(i);
                    if (agenciesObj.has("agency_type") && agenciesObj.getString("agency_type").equalsIgnoreCase("Sport")) {
                        playerSportsAgent = agenciesObj.getString("name");
                    } else if (agenciesObj.has("agency_type") && agenciesObj.getString("agency_type").equalsIgnoreCase("Television")) {
                        playerTelevision = agenciesObj.getString("name");
                    }
                }

            }

            if (jsonObject.has("current_contracts")) {
                JSONArray contractArray = jsonObject.getJSONArray("current_contracts");
                for (int i = 0; i < contractArray.length(); i++) {
                    JSONObject contractObj = contractArray.getJSONObject(i);
                    if (contractObj.has("contract_name")) {
                        currentContract = contractObj.getString("contract_name");
                    }
                }

            }
            ArrayList<CharityCommunityBeans> charityArrayList = new ArrayList<>();
            ArrayList<CharityCommunityBeans> communityArrayList = new ArrayList<>();

// community works
            if (jsonObject.has("community_works")) {
                JSONArray communityJsonArray = jsonObject.getJSONArray("community_works");
                for (int i = 0; i < communityJsonArray.length(); i++) {
                    JSONObject communityObj = communityJsonArray.getJSONObject(i);
                    CharityCommunityBeans charityCommunityBeans = new CharityCommunityBeans();
                    charityCommunityBeans.setContentText(communityObj.getString("description"));
                    JSONArray assetJsonArray = communityObj.getJSONArray("assets");
                    String filePath = "";
                    if (assetJsonArray.length() > 0) {
                        JSONObject assetsObj = assetJsonArray.getJSONObject(0);
                        charityCommunityBeans.setImgUrl(assetsObj.getString("file_name"));
                    }

                    communityArrayList.add(charityCommunityBeans);
                }
            }
//            charity
            if (jsonObject.has("charity_donations")) {
                JSONArray communityJsonArray = jsonObject.getJSONArray("charity_donations");
                for (int i = 0; i < communityJsonArray.length(); i++) {
                    JSONObject communityObj = communityJsonArray.getJSONObject(i);
                    CharityCommunityBeans charityCommunityBeans = new CharityCommunityBeans();
                    charityCommunityBeans.setContentText(communityObj.getString("description"));
                    JSONArray assetJsonArray = communityObj.getJSONArray("assets");
                    String filePath = "";
                    if (assetJsonArray.length() > 0) {
                        JSONObject assetsObj = assetJsonArray.getJSONObject(0);
                        charityCommunityBeans.setImgUrl(assetsObj.getString("file_name"));
                    }

                    charityArrayList.add(charityCommunityBeans);
                }
            }

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
            playerDetailInfoBean.setJersey(jersey != null ? jersey : "");
            playerDetailInfoBean.setDraft(draft != null ? draft : "");
            playerDetailInfoBean.setCommunityArrayList(communityArrayList);
            playerDetailInfoBean.setCharityArrayList(charityArrayList);


//            career heights
            if (jsonObject.has("career_highlights")) {
                JSONArray careerArray = jsonObject.getJSONArray("career_highlights");
                for (int i = 0; i < careerArray.length(); i++) {
                    JSONObject careerObj = careerArray.getJSONObject(i);
                    if (careerObj.has("description")) {
                        careerHeights.add(careerObj.getString("description"));
                    }
                }
            }

//            getting video
//            videosBeanArrayList
            if (jsonObject.has("videos")) {
                JSONArray videoArray = jsonObject.getJSONArray("videos");
                for (int i = 0; i < videoArray.length(); i++) {
                    JSONObject videoObj = videoArray.getJSONObject(i);
                    VideosBean videosBean = new VideosBean();
                    videosBean.setVideoUrl(videoObj.getString("file_name"));
                    videosBean.setThumbnail(videoObj.getString("thumbnail"));
                    videosBean.setVideoTitle(videoObj.getString("display_name"));
                    videosBeanArrayList.add(videosBean);
                }
            }

//            imagesArray
            if (jsonObject.has("gallery")) {
                JSONArray imageArray = jsonObject.getJSONArray("gallery");
                for (int i = 0; i < imageArray.length(); i++) {
                    JSONObject imageObj = imageArray.getJSONObject(i);
                    if (imageObj.has("file_name")) {
                        imageListString.add(imageObj.getString("file_name"));
                    }
                }
            }

//            Bio
            String bio = jsonObject.getString("about") != null ? jsonObject.getString("about") : "";


//            Status data
            if (jsonObject.has("stats") && jsonObject.getJSONObject("stats") != null) {
//                StatsData2(jsonObject.getJSONObject("stats"));
                statsBeansArrayList = StatsData(jsonObject.getJSONObject("stats"));
            }
            getMvpView().fetchPlayerDetailInfo(playerDetailInfoBean, careerHeights, imageListString, videosBeanArrayList, bio, statsBeansArrayList);
        } catch (JSONException e) {
            e.printStackTrace();
            getMvpView().errorOccur(e.toString());
        }
    }


    //    stats data
    private ArrayList<StatsBeans> StatsData(JSONObject jsonObject) {
        ArrayList<StatsBeans> statsBeansArrayList = new ArrayList<>();
        StatsBeans statsBeans = new StatsBeans();
        ArrayList<StatsBeans.InnerStatsBean> innerStatsBeanArrayList = new ArrayList<>();
        ArrayList<List<String>> nestingArrayList = null;
        Iterator topIterator = jsonObject.keys();
        int invisible = 0;

        while (topIterator.hasNext()) {
            try {
//                get value from top key
                String topKey = (String) topIterator.next();
                invisible = 0;
                JSONObject regObj = jsonObject.getJSONObject(topKey);
                Iterator iterator = regObj.keys();
                while (iterator.hasNext()) {
//                    get nested node (title) key is a title
                    String key = (String) iterator.next();
                    StatsBeans.InnerStatsBean innerStatsBean = new StatsBeans.InnerStatsBean();
                    innerStatsBean.setHeaderText(key);

                    if (invisible == 0) {
                        innerStatsBean.setMainHeaderText(topKey);
                        invisible++;
                    } else {
                        innerStatsBean.setMainHeaderText("invisible");
                    }

                    JSONObject regContent = regObj.getJSONObject(key);
                    Iterator regIterator = regContent.keys();

                    int i = 0;

                    nestingArrayList = new ArrayList<>();

                    while (regIterator.hasNext()) {
//                       get  years from nested node
//                       give size to vertical recycler view
                        String regIteratorKey = (String) regIterator.next();
                        Log.e("Keys=2222==>   ", regIteratorKey);
                        List<String> nestedList = new ArrayList<>();
                        if (i != 0)
                            nestedList.add(regIteratorKey);
                        JSONObject dataObj = regContent.getJSONObject(regIteratorKey);
                        Iterator dataObjIterator = dataObj.keys();

                        if (i == 0) {
                            nestedList.add("Year");
                            while (dataObjIterator.hasNext()) {
//                            data from nested node
                                if (i == 0) {
                                    String dataIteratorKey = (String) dataObjIterator.next();
                                    nestedList.add(dataIteratorKey);
                                }
                            }
                            i++;
                        }

                        while (dataObjIterator.hasNext()) {
//                            data from nested node
                            String dataIteratorKey = (String) dataObjIterator.next();
                            if (i == 0) {
                                nestedList.add(dataIteratorKey);
                            } else {
                                nestedList.add(dataObj.getString(dataIteratorKey));
                            }

                            Log.e("Keys=3333==>   ", dataIteratorKey);
                        }

                        nestingArrayList.add(nestedList);
                        i++;

                    }
                    innerStatsBean.setListArrayList(nestingArrayList);
                    innerStatsBeanArrayList.add(innerStatsBean);


                }
                invisible++;
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
        statsBeans.setInnerStatsBeansList(innerStatsBeanArrayList);
        statsBeansArrayList.add(statsBeans);

        return statsBeansArrayList;
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
//    //    stats data
//    private ArrayList<StatsBeans> StatsData2(JSONObject jsonObject) {
//
//        ArrayList<StatsBeans2> statsBeans2s = new ArrayList<>();
//        StatsBeans2 statsBeans2 = new StatsBeans2();
//
//        JSONArray topJsonArray = jsonObject.names();
//        try {
//            for (int i = 0; i < topJsonArray.length(); i++) {
//
//                JSONObject topJsonObj = topJsonArray
//                topJsonObj.names().length();
//
//
//
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        ArrayList<StatsBeans> statsBeansArrayList = new ArrayList<>();
//        StatsBeans statsBeans = new StatsBeans();
//        ArrayList<StatsBeans.InnerStatsBean> innerStatsBeanArrayList = new ArrayList<>();
//        ArrayList<List<String>> nestingArrayList = null;
//        Iterator topIterator = jsonObject.keys();
//        int invisible = 0;
//
//        while (topIterator.hasNext()) {
//            try {
////                get value from top key
//                String topKey = (String) topIterator.next();
//                invisible = 0;
//                JSONObject regObj = jsonObject.getJSONObject(topKey);
//                Iterator iterator = regObj.keys();
//                while (iterator.hasNext()) {
////                    get nested node (title) key is a title
//                    String key = (String) iterator.next();
//                    StatsBeans.InnerStatsBean innerStatsBean = new StatsBeans.InnerStatsBean();
//                    innerStatsBean.setHeaderText(key);
//
//                    if (invisible == 0) {
//                        innerStatsBean.setMainHeaderText(topKey);
//                        invisible++;
//                    } else {
//                        innerStatsBean.setMainHeaderText("invisible");
//                    }
//
//                    JSONObject regContent = regObj.getJSONObject(key);
//                    Iterator regIterator = regContent.keys();
//
//                    int i = 0;
//
//                    nestingArrayList = new ArrayList<>();
//
//                    while (regIterator.hasNext()) {
////                       get  years from nested node
////                       give size to vertical recycler view
//                        String regIteratorKey = (String) regIterator.next();
//                        Log.e("Keys=2222==>   ", regIteratorKey);
//                        List<String> nestedList = new ArrayList<>();
//                        if (i != 0)
//                            nestedList.add(regIteratorKey);
//                        JSONObject dataObj = regContent.getJSONObject(regIteratorKey);
//                        Iterator dataObjIterator = dataObj.keys();
//
//                        if (i == 0) {
//                            nestedList.add("Year");
//                            while (dataObjIterator.hasNext()) {
////                            data from nested node
//                                if (i == 0) {
//                                    String dataIteratorKey = (String) dataObjIterator.next();
//                                    nestedList.add(dataIteratorKey);
//                                }
//                            }
//                            i++;
//                        }
//
//                        while (dataObjIterator.hasNext()) {
////                            data from nested node
//                            String dataIteratorKey = (String) dataObjIterator.next();
//                            if (i == 0) {
//                                nestedList.add(dataIteratorKey);
//                            } else {
//                                nestedList.add(dataObj.getString(dataIteratorKey));
//                            }
//
//                            Log.e("Keys=3333==>   ", dataIteratorKey);
//                        }
//
//                        nestingArrayList.add(nestedList);
//                        i++;
//
//                    }
//                    innerStatsBean.setListArrayList(nestingArrayList);
//                    innerStatsBeanArrayList.add(innerStatsBean);
//
//
//                }
//                invisible++;
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//
//
//        }
//        statsBeans.setInnerStatsBeansList(innerStatsBeanArrayList);
//        statsBeansArrayList.add(statsBeans);
//
//        return statsBeansArrayList;
//    }
//}

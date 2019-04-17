package com.osdb.app.ui.player_details_screen.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.osdb.app.data.app_prefs.AppPreferenceHelperClass;
import com.osdb.app.ui.DemoTable.Cell;
import com.osdb.app.ui.DemoTable.ColumnHeader;
import com.osdb.app.ui.DemoTable.RowHeader;
import com.osdb.app.ui.base.presenter.BasePresenterClass;
import com.osdb.app.ui.player_details_screen.beans.CharityCommunityBeans;
import com.osdb.app.ui.player_details_screen.beans.PlayerDetailInfoBean;
import com.osdb.app.ui.player_details_screen.beans.VideosBean;
import com.osdb.app.ui.player_details_screen.model.PlayerDetailsInteractor;
import com.osdb.app.ui.player_details_screen.model.PlayerDetailsInteractorClass;
import com.osdb.app.ui.player_details_screen.view.PlayerDetailsView;
import com.osdb.app.ui.team_details_screen.beans.StatsBeanVertical;
import com.osdb.app.ui.team_details_screen.beans.TableList;
import com.osdb.app.utils.ConnectivityReceiver;
import com.osdb.app.utils.Utils;
import com.google.gson.JsonElement;
import io.reactivex.functions.Consumer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
        String outputDate = Utils.getFormatedDate(stringDate, "yyyy-MM-dd", "MMM dd, yyyy");
        getMvpView().formattedDate(outputDate);
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
        ArrayList<StatsBeanVertical> statsBeanVerticalArrayList = new ArrayList<>();
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
                if (metaObj.has("draft")) {
                    if (metaObj.get("draft") instanceof JSONObject) {
                        JSONObject draftObj = metaObj.getJSONObject("draft");
                        String year = draftObj.getString("year");
                        String round = draftObj.getString("round");
                        String number = draftObj.getString("number");
                        draft = year + "/Round " + round + "/Pick " + number;
                    } else if (metaObj.get("draft") instanceof String) {
                        String draftObjS = metaObj.getString("draft");
                        if (!TextUtils.isEmpty(draftObjS)) {
                            JSONObject draftObj = new JSONObject("draft");
                            String year = draftObj.getString("year");
                            String round = draftObj.getString("round");
                            String number = draftObj.getString("number");
                            draft = year + "/Round " + round + "/Pick " + number;
                        }
                    }
                }

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
            String bio = jsonObject.getString("about") != null && !jsonObject.getString("about").equalsIgnoreCase("null")? jsonObject.getString("about") : "";


//            Status data
            if (jsonObject.has("stats") && jsonObject.getJSONObject("stats") != null) {
//                StatsData2(jsonObject.getJSONObject("stats"));
                statsBeanVerticalArrayList = StatsData(jsonObject.getJSONObject("stats"));
            }
            getMvpView().fetchPlayerDetailInfo(playerDetailInfoBean, careerHeights, imageListString, videosBeanArrayList, bio, statsBeanVerticalArrayList);
        } catch (JSONException e) {
            e.printStackTrace();
            getMvpView().errorOccur(e.toString());
        }
    }

    private ArrayList<StatsBeanVertical> StatsData(JSONObject jsonObject) {
        List<RowHeader> rowHeaderArrayList = null;
        List<ColumnHeader> columnHeaderArrayList = null;
        List<List<Cell>> cellListMain = null;

        Iterator mainHeaderKey = jsonObject.keys();
        ArrayList<StatsBeanVertical> statsBeanVerticalArrayList = new ArrayList<>();
        StatsBeanVertical statsBeanVertical = null;
        while (mainHeaderKey.hasNext()) {

            String mainStringKey = (String) mainHeaderKey.next();

            try {
                JSONObject regObj = jsonObject.getJSONObject(mainStringKey);
                Iterator headerIterator = regObj.keys();

                while (headerIterator.hasNext()) {
                    TableList tableList = new TableList();
                    int i = 0;


                    String headerKey = (String) headerIterator.next();


                    JSONObject puntsObj = regObj.getJSONObject(headerKey);
                    Iterator puntsIterator = puntsObj.keys();
                    rowHeaderArrayList = new ArrayList<>();
                    columnHeaderArrayList = new ArrayList<>();
                    cellListMain = new ArrayList<>();
                    while (puntsIterator.hasNext()) {
                        //            set main header
                        statsBeanVertical = new StatsBeanVertical();
                        statsBeanVertical.setMainHeader(mainStringKey);

                        //            set  header
                        statsBeanVertical.setHeader(headerKey);
//                     get year (rows data)
                        String rowsData = (String) puntsIterator.next();
                        RowHeader rowHeader = new RowHeader(rowsData);
                        rowHeaderArrayList.add(rowHeader);

                        JSONObject columnData = puntsObj.getJSONObject(rowsData);
                        Iterator columnIterator = columnData.keys();
//                        get column header and cells data

                        List<Cell> cellList = new ArrayList<>();
                        while (columnIterator.hasNext()) {
                            String columnString = (String) columnIterator.next();
                            if (i == 0) {
                                ColumnHeader columnHeader = new ColumnHeader(columnString);
                                columnHeaderArrayList.add(columnHeader);
                                Cell cell = new Cell(columnData.getString(columnString));
                                cellList.add(cell);
                            } else {
                                Cell cell = new Cell(columnData.getString(columnString));
                                cellList.add(cell);
                            }
                        }
                        i++;
                        cellListMain.add(cellList);
                    }
                    tableList.setCellList(cellListMain);
                    tableList.setColumnHeaderList(columnHeaderArrayList);
                    tableList.setRowHeaderList(rowHeaderArrayList);
                    statsBeanVertical.setTableList(tableList);
                    statsBeanVerticalArrayList.add(statsBeanVertical);
                }


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return statsBeanVerticalArrayList;
    }

}

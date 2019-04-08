package com.elintminds.osdb.ui.team_details_screen.presenter;

import android.content.Context;
import android.util.Log;
import com.elintminds.osdb.data.app_prefs.AppPreferenceHelperClass;
import com.elintminds.osdb.ui.base.presenter.BasePresenterClass;
import com.elintminds.osdb.ui.team_details_screen.beans.StatsBeans;
import com.elintminds.osdb.ui.team_details_screen.model.StatsInteractor;
import com.elintminds.osdb.ui.team_details_screen.model.StatsInteractorClass;
import com.elintminds.osdb.ui.team_details_screen.view.StatsView;
import com.elintminds.osdb.utils.ConnectivityReceiver;
import com.google.gson.JsonElement;
import io.reactivex.functions.Consumer;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StatsPresenterClass<V extends StatsView, I extends StatsInteractor>
        extends BasePresenterClass<V, I> implements StatsPresenter<V, I> {

    public StatsPresenterClass(Context context, I interactor, V view) {
        super(context, interactor, view);
    }

    public StatsPresenterClass(Context context, V view) {
        this(context, (I) new StatsInteractorClass(new AppPreferenceHelperClass(context), context), view);
    }

    @Override
    public void fetchTeamStatsData(String teamId) {
        if (ConnectivityReceiver.isConnected()) {
            getMvpView().showProgressDialog();
            getCompositeDisposable().add(getInteractor()
                    .fetchTeamsStats(teamId)
                    .subscribeOn(getSchedulerProvider().io())
                    .observeOn(getSchedulerProvider().ui())
                    .subscribe(new Consumer<Response<JsonElement>>() {
                                   @Override
                                   public void accept(retrofit2.Response<JsonElement> response) throws Exception {
                                       Log.e("HomeSwipeData", "   Inside Success");
                                       if (response.isSuccessful()) {
                                           if (response.body() != null)
                                               parseData(response.body().toString());
                                           //            Status data

                                       } else {
                                           getMvpView().error("Something went wrong");
                                       }
                                       getMvpView().hideProgressDialog();
                                   }
                               },
                            new Consumer<Throwable>() {
                                @Override
                                public void accept(Throwable throwable) throws Exception {
                                    Log.e("HomeSwipeData", "   Inside Reject");
                                    getMvpView().error(throwable.toString());
                                    getMvpView().hideProgressDialog();
                                }
                            }));
        } else {
            getMvpView().error("No Internet connection");
        }
    }

    private void parseData(String toString) {
        try {
            JSONObject jsonObject = new JSONObject(toString);
            if (jsonObject.has("stats") && jsonObject.getJSONObject("stats") != null) {
                StatsData(jsonObject.getJSONObject("stats"));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void StatsData(JSONObject jsonObject) {
        long startTime = System.currentTimeMillis();
        ArrayList<StatsBeans> statsBeansArrayList = new ArrayList<>();
        StatsBeans statsBeans = new StatsBeans();
        ArrayList<StatsBeans.InnerStatsBean> innerStatsBeanArrayList = new ArrayList<>();
        ArrayList<List<String>> nestingArrayList = null;
        Iterator topIterator = jsonObject.keys();
        int invisible = 0;
        int size = jsonObject.names().length();
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
        long endTime = System.currentTimeMillis();
        Log.e("TimeSuccessStats", endTime - startTime + "");
        getMvpView().success(statsBeansArrayList);
    }
}

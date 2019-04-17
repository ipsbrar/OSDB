package com.osdb.app.ui.team_details_screen.presenter;

import android.content.Context;
import android.util.Log;
import com.osdb.app.data.app_prefs.AppPreferenceHelperClass;
import com.osdb.app.ui.DemoTable.Cell;
import com.osdb.app.ui.DemoTable.ColumnHeader;
import com.osdb.app.ui.DemoTable.RowHeader;
import com.osdb.app.ui.base.presenter.BasePresenterClass;
import com.osdb.app.ui.team_details_screen.beans.StatsBeanVertical;
import com.osdb.app.ui.team_details_screen.beans.TableList;
import com.osdb.app.ui.team_details_screen.model.StatsInteractor;
import com.osdb.app.ui.team_details_screen.model.StatsInteractorClass;
import com.osdb.app.ui.team_details_screen.view.StatsView;
import com.osdb.app.ui.team_details_screen.view.TeamDetailsActivity;
import com.osdb.app.utils.ConnectivityReceiver;
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
    private Context context;
    private ArrayList<StatsBeanVertical> statsBeanVerticalArrayList;

    public StatsPresenterClass(Context context, I interactor, V view) {
        super(context, interactor, view);
        this.context = context;
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

    private void StatsData(final JSONObject jsonObject) {

        statsBeanVerticalArrayList = new ArrayList<>();
        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                List<RowHeader> rowHeaderArrayList = null;
                List<ColumnHeader> columnHeaderArrayList = null;
                List<List<Cell>> cellListMain = null;
                Iterator mainHeaderKey = jsonObject.keys();

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
                Thread.currentThread().interrupt();
                ((TeamDetailsActivity) context).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        getMvpView().success(statsBeanVerticalArrayList);
                    }
                });


            }
        });
        thread.start();

    }

}

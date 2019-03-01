package com.elintminds.osdb.ui.dashboard.model;

import com.elintminds.osdb.ui.base.model.BaseInteractor;
import com.elintminds.osdb.ui.dashboard.beans.BornTodayAdapterBean;
import com.elintminds.osdb.ui.dashboard.beans.HomeAdapterListBean;
import com.elintminds.osdb.ui.dashboard.beans.SportsAdapterListBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.ArrayList;

public interface HomeFragmentInteractor extends BaseInteractor
{
    Observable<ArrayList<SportsAdapterListBean>> getAllSportsList();
    Observable<ArrayList<HomeAdapterListBean>> getAllHomeList();
    Observable<ArrayList<BornTodayAdapterBean>> getBornTodayList(String currentDate, String limit);
}

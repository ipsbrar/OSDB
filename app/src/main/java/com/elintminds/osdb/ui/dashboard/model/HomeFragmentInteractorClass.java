package com.elintminds.osdb.ui.dashboard.model;

import android.content.Context;
import com.elintminds.osdb.data.app_prefs.PreferenceHelper;
import com.elintminds.osdb.ui.base.model.BaseInteractorClass;
import com.elintminds.osdb.ui.dashboard.beans.BornTodayAdapterBean;
import com.elintminds.osdb.ui.dashboard.beans.HomeAdapterListBean;
import com.elintminds.osdb.ui.dashboard.beans.SportsAdapterListBean;
import io.reactivex.Observable;

import java.util.ArrayList;

public class HomeFragmentInteractorClass extends BaseInteractorClass implements HomeFragmentInteractor {

    public HomeFragmentInteractorClass(PreferenceHelper prefHelper, Context context) {
        super(prefHelper, context);
    }

    @Override
    public Observable<ArrayList<SportsAdapterListBean>> getAllSportsList() {
        return getApiInterface().fetchAllSportsList();
    }

    @Override
    public Observable<ArrayList<HomeAdapterListBean>> getAllHomeList() {
        return null;
    }

    @Override
    public Observable<ArrayList<BornTodayAdapterBean>> getBornTodayList(String currentDate, String limit) {
        return getApiInterface().fetchBornTodayData(currentDate, limit);
    }
}

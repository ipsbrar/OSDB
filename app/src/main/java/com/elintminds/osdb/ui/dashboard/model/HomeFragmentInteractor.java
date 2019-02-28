package com.elintminds.osdb.ui.dashboard.model;

import com.elintminds.osdb.ui.base.model.BaseInteractor;
import com.elintminds.osdb.ui.dashboard.beans.HomeAdapterListBean;
import com.elintminds.osdb.ui.dashboard.beans.SportsAdapterListBean;
import io.reactivex.Observable;

import java.util.ArrayList;

public interface HomeFragmentInteractor extends BaseInteractor {
    Observable<ArrayList<SportsAdapterListBean>> getAllSportsList();
    Observable<ArrayList<HomeAdapterListBean>> getAllHomeList();
}

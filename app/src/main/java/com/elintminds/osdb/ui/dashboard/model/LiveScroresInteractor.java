package com.elintminds.osdb.ui.dashboard.model;

import com.elintminds.osdb.ui.base.model.BaseInteractor;
import com.elintminds.osdb.ui.dashboard.beans.SportsAdapterListBean;
import io.reactivex.Observable;

import java.util.ArrayList;

public interface LiveScroresInteractor extends BaseInteractor {
    Observable<ArrayList<SportsAdapterListBean>> getAllSportsList();
}

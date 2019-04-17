package com.osdb.app.ui.dashboard.model;

import com.osdb.app.ui.base.model.BaseInteractor;
import com.osdb.app.ui.dashboard.beans.SportsAdapterListBean;
import io.reactivex.Observable;

import java.util.ArrayList;

public interface LiveScroresInteractor extends BaseInteractor {
    Observable<ArrayList<SportsAdapterListBean>> getAllSportsList();
}

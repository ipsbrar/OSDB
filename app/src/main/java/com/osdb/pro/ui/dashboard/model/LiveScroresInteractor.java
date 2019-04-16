package com.osdb.pro.ui.dashboard.model;

import com.osdb.pro.ui.base.model.BaseInteractor;
import com.osdb.pro.ui.dashboard.beans.SportsAdapterListBean;
import io.reactivex.Observable;

import java.util.ArrayList;

public interface LiveScroresInteractor extends BaseInteractor {
    Observable<ArrayList<SportsAdapterListBean>> getAllSportsList();
}

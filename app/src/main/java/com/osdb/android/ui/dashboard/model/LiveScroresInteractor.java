package com.osdb.android.ui.dashboard.model;

import com.osdb.android.ui.base.model.BaseInteractor;
import com.osdb.android.ui.dashboard.beans.SportsAdapterListBean;
import io.reactivex.Observable;

import java.util.ArrayList;

public interface LiveScroresInteractor extends BaseInteractor {
    Observable<ArrayList<SportsAdapterListBean>> getAllSportsList();
}

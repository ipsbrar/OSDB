package com.elintminds.osdb.ui.dashboard.model;

import android.content.Context;
import com.elintminds.osdb.data.app_prefs.PreferenceHelper;
import com.elintminds.osdb.ui.base.model.BaseInteractorClass;
import com.elintminds.osdb.ui.dashboard.beans.SportsAdapterListBean;
import io.reactivex.Observable;

import java.util.ArrayList;

public class LiveScroresInteractorClass extends BaseInteractorClass implements LiveScroresInteractor
{
    public LiveScroresInteractorClass(PreferenceHelper prefHelper, Context context) {
        super(prefHelper, context);
    }
    @Override
    public Observable<ArrayList<SportsAdapterListBean>> getAllSportsList() {
        return getApiInterface().fetchAllSportsList();
    }
}

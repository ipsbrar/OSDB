package com.osdb.app.ui.dashboard.model;

import android.content.Context;
import com.osdb.app.data.app_prefs.PreferenceHelper;
import com.osdb.app.ui.base.model.BaseInteractorClass;
import com.osdb.app.ui.dashboard.beans.SportsAdapterListBean;
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

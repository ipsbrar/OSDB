package com.osdb.pro.ui.dashboard.model;

import android.content.Context;
import com.osdb.pro.data.app_prefs.PreferenceHelper;
import com.osdb.pro.ui.base.model.BaseInteractorClass;
import com.osdb.pro.ui.dashboard.beans.SportsAdapterListBean;
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

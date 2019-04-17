package com.osdb.app.ui.base.model;


import com.osdb.app.data.app_prefs.PreferenceHelper;
import com.osdb.app.data.network.ApiHelper;

public interface BaseInteractor
{
    PreferenceHelper getPreferenceHelper();

    ApiHelper getApiInterface();

    ApiHelper getPlacesApiInterface();
}
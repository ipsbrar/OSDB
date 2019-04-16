package com.osdb.pro.ui.base.model;


import com.osdb.pro.data.app_prefs.PreferenceHelper;
import com.osdb.pro.data.network.ApiHelper;

public interface BaseInteractor
{
    PreferenceHelper getPreferenceHelper();

    ApiHelper getApiInterface();

    ApiHelper getPlacesApiInterface();
}
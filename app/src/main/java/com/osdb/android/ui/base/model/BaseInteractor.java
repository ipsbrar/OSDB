package com.osdb.android.ui.base.model;


import com.osdb.android.data.app_prefs.PreferenceHelper;
import com.osdb.android.data.network.ApiHelper;

public interface BaseInteractor
{
    PreferenceHelper getPreferenceHelper();

    ApiHelper getApiInterface();

    ApiHelper getPlacesApiInterface();
}
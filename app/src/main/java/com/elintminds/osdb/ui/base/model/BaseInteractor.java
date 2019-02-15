package com.elintminds.osdb.ui.base.model;


import com.elintminds.osdb.data.app_prefs.PreferenceHelper;
import com.elintminds.osdb.data.network.ApiHelper;

public interface BaseInteractor
{
    PreferenceHelper getPreferenceHelper();

    ApiHelper getApiInterface();

    ApiHelper getPlacesApiInterface();
}
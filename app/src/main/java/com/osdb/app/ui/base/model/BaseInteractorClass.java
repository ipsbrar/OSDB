package com.osdb.app.ui.base.model;


import android.content.Context;

import com.osdb.app.data.app_prefs.PreferenceHelper;
import com.osdb.app.data.network.ApiClient;
import com.osdb.app.data.network.ApiHelper;

public class BaseInteractorClass implements BaseInteractor
{
    private PreferenceHelper prefHelper;
    private ApiHelper apiInterface;
    private ApiHelper placeApiInterface;
    private  Context context;

    public BaseInteractorClass(PreferenceHelper prefHelper,Context context)
    {
        this.prefHelper = prefHelper;
        this.context=context;
        this.apiInterface = ApiClient.INSTANCE.getClient(context).create(ApiHelper.class);
//        this.placeApiInterface = ApiClient.INSTANCE.placeSearch().create(ApiHelper.class);
    }

    @Override
    public PreferenceHelper getPreferenceHelper()
    {
        return prefHelper;
    }

    @Override
    public ApiHelper getApiInterface()
    {
        return apiInterface;
    }

    @Override
    public ApiHelper getPlacesApiInterface()
    {
        return placeApiInterface;
    }




}

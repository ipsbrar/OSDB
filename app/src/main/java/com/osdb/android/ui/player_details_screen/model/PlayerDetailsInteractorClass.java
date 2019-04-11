package com.osdb.android.ui.player_details_screen.model;

import android.content.Context;
import com.osdb.android.data.app_prefs.PreferenceHelper;
import com.osdb.android.ui.base.model.BaseInteractorClass;
import com.google.gson.JsonElement;
import io.reactivex.Observable;
import retrofit2.Response;

public class PlayerDetailsInteractorClass extends BaseInteractorClass implements PlayerDetailsInteractor
{
    public PlayerDetailsInteractorClass(PreferenceHelper prefHelper, Context context)
    {
        super(prefHelper, context);
    }

    @Override
    public Observable<Response<JsonElement>> fetchPlayerDetail(String playerId) {
        return getApiInterface().fetchPlayerDetail(playerId);
    }
}

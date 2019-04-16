package com.osdb.pro.ui.player_details_screen.model;

import com.osdb.pro.ui.base.model.BaseInteractor;
import com.google.gson.JsonElement;
import io.reactivex.Observable;
import retrofit2.Response;

public interface PlayerDetailsInteractor extends BaseInteractor {
    Observable<Response<JsonElement>> fetchPlayerDetail(String playerId);
}

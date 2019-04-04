package com.elintminds.osdb.ui.player_details_screen.model;

import com.elintminds.osdb.ui.base.model.BaseInteractor;
import com.google.gson.JsonElement;
import io.reactivex.Observable;
import org.json.JSONObject;
import retrofit2.Response;

public interface PlayerDetailsInteractor extends BaseInteractor {
    Observable<Response<JsonElement>> fetchPlayerDetail(String playerId);
}

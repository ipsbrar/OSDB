package com.osdb.app.ui.search_screen.model;

import android.content.Context;
import com.osdb.app.data.app_prefs.PreferenceHelper;
import com.osdb.app.ui.base.model.BaseInteractorClass;
import com.osdb.app.ui.search_screen.beans.SearchModal;
import io.reactivex.Observable;
import retrofit2.Response;

public class SearchScreenInteractorClass extends BaseInteractorClass implements SearchScreenInteractor
{
    public SearchScreenInteractorClass(PreferenceHelper prefHelper, Context context)
    {
        super(prefHelper, context);
    }

    @Override
    public Observable<Response<SearchModal>> searchModal(String searchContent, String category) {
        return getApiInterface().search(searchContent, category);
    }
}

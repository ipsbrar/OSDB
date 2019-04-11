package com.osdb.android.ui.search_screen.model;

import android.content.Context;
import com.osdb.android.data.app_prefs.PreferenceHelper;
import com.osdb.android.ui.base.model.BaseInteractorClass;
import com.osdb.android.ui.search_screen.beans.SearchModal;
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

package com.osdb.pro.ui.search_screen.model;

import android.content.Context;
import com.osdb.pro.data.app_prefs.PreferenceHelper;
import com.osdb.pro.ui.base.model.BaseInteractorClass;
import com.osdb.pro.ui.search_screen.beans.SearchModal;
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

package com.osdb.android.ui.dashboard.model;

import android.content.Context;
import com.osdb.android.data.app_prefs.PreferenceHelper;
import com.osdb.android.ui.base.model.BaseInteractorClass;
import com.osdb.android.ui.dashboard.beans.NewsAdapterBean;
import io.reactivex.Observable;

public class NewsFragmentInteractorClass extends BaseInteractorClass implements NewsFragmentInteractor {
    public NewsFragmentInteractorClass(PreferenceHelper prefHelper, Context context) {
        super(prefHelper, context);
    }

    @Override
    public Observable<NewsAdapterBean> getAllNewsList(int offset) {
        return getApiInterface().fetchAllNews(offset);
    }
}

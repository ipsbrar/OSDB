package com.elintminds.osdb.ui.dashboard.model;

import android.content.Context;
import com.elintminds.osdb.data.app_prefs.PreferenceHelper;
import com.elintminds.osdb.ui.base.model.BaseInteractorClass;
import com.elintminds.osdb.ui.dashboard.beans.PollAdapterBean;
import io.reactivex.Observable;

import java.util.ArrayList;

public class PollsInterctorClass extends BaseInteractorClass implements PollsInteractor {


    public PollsInterctorClass(PreferenceHelper prefHelper, Context context) {
        super(prefHelper, context);
    }

    @Override
    public Observable<PollAdapterBean> getPollsDataList(String currDate, String userId) {
        return getApiInterface().getPollsData(userId);
    }
}

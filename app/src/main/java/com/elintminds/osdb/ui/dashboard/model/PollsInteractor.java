package com.elintminds.osdb.ui.dashboard.model;

import com.elintminds.osdb.ui.base.model.BaseInteractor;
import com.elintminds.osdb.ui.dashboard.beans.PollAdapterBean;
import io.reactivex.Observable;

import java.util.ArrayList;

public interface PollsInteractor extends BaseInteractor {

    Observable<ArrayList<PollAdapterBean>> getPollsDataList(String currDate, String userId);
}

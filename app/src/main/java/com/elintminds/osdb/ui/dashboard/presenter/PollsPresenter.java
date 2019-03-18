package com.elintminds.osdb.ui.dashboard.presenter;

import android.content.Context;
import com.elintminds.osdb.ui.base.presenter.BasePresenter;
import com.elintminds.osdb.ui.dashboard.model.DashboardInteractor;
import com.elintminds.osdb.ui.dashboard.model.PollsInteractor;
import com.elintminds.osdb.ui.dashboard.view.DashboardView;
import com.elintminds.osdb.ui.dashboard.view.PollView;

public interface PollsPresenter <V extends PollView, I extends PollsInteractor> extends BasePresenter<V, I> {


    void getPollsData(String currentDate, String userId);

    void VotePolls(Context context, String pollId, String optionId, String token);
}

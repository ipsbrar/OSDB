package com.osdb.app.ui.dashboard.presenter;

import android.content.Context;
import com.osdb.app.ui.base.presenter.BasePresenter;
import com.osdb.app.ui.dashboard.model.PollsInteractor;
import com.osdb.app.ui.dashboard.view.PollView;

public interface PollsPresenter <V extends PollView, I extends PollsInteractor> extends BasePresenter<V, I> {


    void getPollsData(String currentDate, String userId);

    void VotePolls(Context context, String pollId, String optionId, String token);
}

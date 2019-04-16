package com.osdb.pro.ui.dashboard.presenter;

import android.content.Context;
import com.osdb.pro.ui.base.presenter.BasePresenter;
import com.osdb.pro.ui.dashboard.model.PollsInteractor;
import com.osdb.pro.ui.dashboard.view.PollView;

public interface PollsPresenter <V extends PollView, I extends PollsInteractor> extends BasePresenter<V, I> {


    void getPollsData(String currentDate, String userId);

    void VotePolls(Context context, String pollId, String optionId, String token);
}

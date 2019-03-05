package com.elintminds.osdb.ui.dashboard.presenter;

import android.content.Context;
import android.util.Log;
import com.elintminds.osdb.data.app_prefs.AppPreferenceHelperClass;
import com.elintminds.osdb.ui.base.presenter.BasePresenterClass;
import com.elintminds.osdb.ui.dashboard.beans.PollAdapterBean;
import com.elintminds.osdb.ui.dashboard.model.PollsInteractor;
import com.elintminds.osdb.ui.dashboard.model.PollsInterctorClass;
import com.elintminds.osdb.ui.dashboard.view.PollView;
import io.reactivex.functions.Consumer;

import java.util.ArrayList;

public class PollsPresenterClass<V extends PollView, I extends PollsInteractor>
        extends BasePresenterClass<V, I> implements PollsPresenter<V, I> {
    public PollsPresenterClass(Context context, I interactor, V view) {
        super(context, interactor, view);
    }

    public PollsPresenterClass(Context context, V view) {
        this(context, (I) new PollsInterctorClass(new AppPreferenceHelperClass(context), context), view);
    }

    @Override
    public void getPollsData(String currentDate, String userId) {
        getCompositeDisposable().add(getInteractor()
                .getPollsDataList(currentDate, userId)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<ArrayList<PollAdapterBean>>() {
                               @Override
                               public void accept(ArrayList<PollAdapterBean> pollList) throws Exception {
                                   Log.e("PollData", "Success=======" + pollList.get(0).getId());

                                   getMvpView().getPollData(pollList);

                               }
                           },
                        new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                Log.e("PollData", "Error=======    " + throwable.toString());
                                // getMvpView().getError(throwable.toString());
                            }
                        }));

    }

}

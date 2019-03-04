package com.elintminds.osdb.ui.dashboard.presenter;

import android.content.Context;
import android.util.Log;
import com.elintminds.osdb.data.app_prefs.AppPreferenceHelperClass;
import com.elintminds.osdb.ui.base.presenter.BasePresenterClass;
import com.elintminds.osdb.ui.dashboard.beans.DiscussionAdapterBean;
import com.elintminds.osdb.ui.dashboard.model.DiscussionInteractor;
import com.elintminds.osdb.ui.dashboard.model.DiscussionInteractorClass;
import com.elintminds.osdb.ui.dashboard.view.DiscussionView;
import io.reactivex.functions.Consumer;

import java.util.ArrayList;


public class DiscussionPresenterClass <V extends DiscussionView, I extends DiscussionInteractor>
        extends BasePresenterClass<V, I> implements DiscussionPresenter<V, I> {


    private DiscussionPresenterClass(Context context, I interactor, V view) {
        super(context, interactor, view);
    }

    public DiscussionPresenterClass(Context context, V view) {
        this(context, (I) new DiscussionInteractorClass(new AppPreferenceHelperClass(context), context), view);
    }

    @Override
    public void getDiscussionData() {
        getCompositeDisposable().add(getInteractor()
                .getDiscussion()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<DiscussionAdapterBean>() {
                               @Override
                               public void accept(DiscussionAdapterBean discussionAdapterBean) throws Exception {
                                   Log.e("SportsData","Success=======");
                                   getMvpView().getSuccess(discussionAdapterBean);
                               }
                           },
                        new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception
                            {
                                Log.e("SportsData","Error=======    "+   throwable.toString());
                                getMvpView().getError(throwable.toString());
                            }
                        }));
    }
}
package com.osdb.app.ui.dashboard.presenter;

import android.content.Context;
import android.util.Log;
import com.osdb.app.data.app_prefs.AppPreferenceHelperClass;
import com.osdb.app.ui.base.presenter.BasePresenterClass;
import com.osdb.app.ui.dashboard.beans.DiscussionAdapterBean;
import com.osdb.app.ui.dashboard.model.DiscussionInteractor;
import com.osdb.app.ui.dashboard.model.DiscussionInteractorClass;
import com.osdb.app.ui.dashboard.view.DiscussionView;
import com.osdb.app.utils.ConnectivityReceiver;
import io.reactivex.functions.Consumer;


public class DiscussionPresenterClass<V extends DiscussionView, I extends DiscussionInteractor>
        extends BasePresenterClass<V, I> implements DiscussionPresenter<V, I> {


    private DiscussionPresenterClass(Context context, I interactor, V view) {
        super(context, interactor, view);
    }

    public DiscussionPresenterClass(Context context, V view) {
        this(context, (I) new DiscussionInteractorClass(new AppPreferenceHelperClass(context), context), view);
    }

    @Override
    public void getDiscussionData() {
        if (ConnectivityReceiver.isConnected()) {
            getCompositeDisposable().add(getInteractor()
                    .getDiscussion()
                    .subscribeOn(getSchedulerProvider().io())
                    .observeOn(getSchedulerProvider().ui())
                    .subscribe(new Consumer<DiscussionAdapterBean>() {
                                   @Override
                                   public void accept(DiscussionAdapterBean discussionAdapterBean) throws Exception {
                                       Log.e("SportsData", "Success=======");
                                       getMvpView().getSuccess(discussionAdapterBean);
                                   }
                               },
                            new Consumer<Throwable>() {
                                @Override
                                public void accept(Throwable throwable) throws Exception {
                                    Log.e("SportsData", "Error=======    " + throwable.toString());
                                    getMvpView().getError(throwable.toString(), true);
                                }
                            }));
        } else {
            getMvpView().getError("No internet found", true);
        }
    }
}
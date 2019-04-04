package com.elintminds.osdb.ui.dashboard.presenter;

import android.content.Context;
import android.util.Log;
import com.elintminds.osdb.data.app_prefs.AppPreferenceHelperClass;
import com.elintminds.osdb.ui.base.presenter.BasePresenterClass;
import com.elintminds.osdb.ui.dashboard.model.DashboardInteractor;
import com.elintminds.osdb.ui.dashboard.model.DashboardInteractorClass;
import com.elintminds.osdb.ui.dashboard.view.DashboardView;
import com.elintminds.osdb.ui.profile.beans.UserInfo;
import com.elintminds.osdb.utils.ConnectivityReceiver;
import io.reactivex.functions.Consumer;

public class DashboardPresenterClass<V extends DashboardView, I extends DashboardInteractor>
        extends BasePresenterClass<V, I> implements DashboardPresenter<V, I>
{

    private DashboardPresenterClass(Context context, I interactor, V view) {
        super(context, interactor, view);
    }

    public DashboardPresenterClass(Context context, V view) {
        this(context, (I) new DashboardInteractorClass(new AppPreferenceHelperClass(context), context), view);
    }

    @Override
    public void getUserID() {
        if (ConnectivityReceiver.isConnected()){
            getMvpView().showProgressDialog();
            getCompositeDisposable().add(getInteractor()
                    .fetchUserInfo()
                    .subscribeOn(getSchedulerProvider().io())
                    .observeOn(getSchedulerProvider().ui())
                    .subscribe(new Consumer<UserInfo>() {
                                   @Override
                                   public void accept(UserInfo userInfo) throws Exception {
                                       getMvpView().success(userInfo);
                                       getMvpView().hideProgressDialog();
                                   }
                               },
                            new Consumer<Throwable>() {
                                @Override
                                public void accept(Throwable throwable) throws Exception {
                                    Log.e("PollData", "Error=======    " + throwable.toString());
                                    getMvpView().error(throwable.toString());
                                    getMvpView().hideProgressDialog();
                                }
                            }));

        }else{
            getMvpView().error("No Internet Connection");
        }
    }
}

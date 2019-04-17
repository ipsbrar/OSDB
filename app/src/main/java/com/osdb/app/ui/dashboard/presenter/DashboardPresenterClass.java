package com.osdb.app.ui.dashboard.presenter;

import android.content.Context;
import android.util.Log;
import com.osdb.app.data.app_prefs.AppPreferenceHelperClass;
import com.osdb.app.ui.base.presenter.BasePresenterClass;
import com.osdb.app.ui.dashboard.model.DashboardInteractor;
import com.osdb.app.ui.dashboard.model.DashboardInteractorClass;
import com.osdb.app.ui.dashboard.view.DashboardView;
import com.osdb.app.ui.profile.beans.UserInfo;
import com.osdb.app.utils.ConnectivityReceiver;
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

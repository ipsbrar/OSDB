package com.osdb.pro.ui.profile.presenter;

import android.content.Context;
import android.util.Log;
import com.osdb.pro.data.app_prefs.AppPreferenceHelperClass;
import com.osdb.pro.ui.base.presenter.BasePresenterClass;
import com.osdb.pro.ui.profile.beans.UserInfo;
import com.osdb.pro.ui.profile.model.ProfileInteractor;
import com.osdb.pro.ui.profile.model.ProfileInteractorClass;
import com.osdb.pro.ui.profile.view.ProfileView;
import com.osdb.pro.utils.ConnectivityReceiver;
import io.reactivex.functions.Consumer;

public class ProfilePresenterClass<V extends ProfileView, I extends ProfileInteractor>
        extends BasePresenterClass<V, I> implements ProfilePresenter<V, I> {
    private ProfilePresenterClass(Context context, I interactor, V view) {
        super(context, interactor, view);
    }

    public ProfilePresenterClass(Context context, V view) {
        this(context, (I) new ProfileInteractorClass(new AppPreferenceHelperClass(context), context), view);
    }

    @Override
    public void getUserInfo() {
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

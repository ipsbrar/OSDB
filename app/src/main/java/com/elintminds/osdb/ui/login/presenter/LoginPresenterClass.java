package com.elintminds.osdb.ui.login.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.elintminds.osdb.data.app_prefs.AppPreferenceHelperClass;
import com.elintminds.osdb.data.network.WebserviceUrls;
import com.elintminds.osdb.ui.base.presenter.BasePresenterClass;
import com.elintminds.osdb.ui.login.beans.UserBean;
import com.elintminds.osdb.ui.login.model.LoginInteractor;
import com.elintminds.osdb.ui.login.model.LoginInteractorClass;
import com.elintminds.osdb.ui.login.view.LoginView;
import com.elintminds.osdb.utils.ConnectivityReceiver;
import io.reactivex.functions.Consumer;

public class LoginPresenterClass<V extends LoginView, I extends LoginInteractor> extends BasePresenterClass<V, I> implements LoginPresenter<V, I> {

    private Context context;

    private LoginPresenterClass(Context context, I interactor, V view) {
        super(context, interactor, view);
    }

    public LoginPresenterClass(Context context, V view) {
        this(context, (I) new LoginInteractorClass(new AppPreferenceHelperClass(context), context), view);
        this.context = context;
    }


    @Override
    public void sendUserValue(String userEmail, String userPassword) {
        if (ConnectivityReceiver.isConnected()) {
            getMvpView().showProgressDialog();
            getCompositeDisposable().add(getInteractor()
                    .doServerLogin(userEmail, userPassword)
                    .subscribeOn(getSchedulerProvider().io())
                    .observeOn(getSchedulerProvider().ui())
                    .subscribe(new Consumer<UserBean>() {
                                   @Override
                                   public void accept(UserBean loginBean) throws Exception {
                                       Log.e("loginstatuspresenter", "Success=======");

                                       if (loginBean.getToken() != null) {
                                           Log.e("loginstatuspresenter", loginBean.getToken());
                                           getMvpView().onSuccess(loginBean);
                                       } else if (loginBean.getError() != null) {
                                           Log.e("loginstatuspresenter", loginBean.getError());
                                           getMvpView().onError(loginBean.getError());
                                       }
                                       getMvpView().hideProgressDialog();
                                   }
                               },
                            new Consumer<Throwable>() {
                                @Override
                                public void accept(Throwable throwable) throws Exception {
                                    Log.e("loginstatuspresenter", "Error=======    " + throwable.toString());
                                    getMvpView().onError(throwable.toString());
                                    getMvpView().hideProgressDialog();

                                }
                            }));

        } else {
            getMvpView().onError("No Internet Connection");
        }
    }

    @Override
    public void onSuccess(String Result) {

    }

    @Override
    public void onError(String Error) {

    }
}

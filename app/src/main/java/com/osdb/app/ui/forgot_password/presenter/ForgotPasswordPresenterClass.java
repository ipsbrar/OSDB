package com.osdb.app.ui.forgot_password.presenter;

import android.content.Context;
import android.util.Log;
import com.osdb.app.R;
import com.osdb.app.data.app_prefs.AppPreferenceHelperClass;
import com.osdb.app.ui.base.presenter.BasePresenterClass;
import com.osdb.app.ui.forgot_password.ForgotPasswordBean;
import com.osdb.app.ui.forgot_password.model.ForgotPasswordInteractor;
import com.osdb.app.ui.forgot_password.model.ForgotPasswordInteractorClass;
import com.osdb.app.ui.forgot_password.view.ForgotPasswordView;
import com.osdb.app.utils.ConnectivityReceiver;
import io.reactivex.functions.Consumer;
import retrofit2.Response;

public class ForgotPasswordPresenterClass<V extends ForgotPasswordView, I extends ForgotPasswordInteractor> extends BasePresenterClass<V, I> implements ForgotPasswordPresenter<V, I> {
    private ForgotPasswordPresenterClass(Context context, I interactor, V view) {
        super(context, interactor, view);
    }

    public ForgotPasswordPresenterClass(Context context, V view) {
        this(context, (I) new ForgotPasswordInteractorClass(new AppPreferenceHelperClass(context), context), view);
    }

    @Override
    public void getEmailToSendResetLink(String email, final Context context) {
        if (ConnectivityReceiver.isConnected()) {
            getMvpView().showProgressDialog();
            getCompositeDisposable().add(getInteractor()
                    .getEmailResetLink(email)
                    .subscribeOn(getSchedulerProvider().io())
                    .observeOn(getSchedulerProvider().ui())
                    .subscribe(new Consumer<Response<ForgotPasswordBean>>() {
                                   @Override
                                   public void accept(Response<ForgotPasswordBean> forgotPasswordBean) throws Exception {
                                       Log.e("loginstatuspresenter", "Success=======");
                                       if (forgotPasswordBean.code() == 200) {
                                           getMvpView().success(context.getString(R.string.forgot_password_link));
                                       } else {
                                           if (forgotPasswordBean.body().getError() != null) {
                                               getMvpView().error(forgotPasswordBean.body().getError());

                                           }
                                       }

                                       getMvpView().hideProgressDialog();
                                   }
                               },
                            new Consumer<Throwable>() {
                                @Override
                                public void accept(Throwable throwable) throws Exception {
                                    Log.e("loginstatuspresenter", "Error=======    " + throwable.toString());
                                    getMvpView().error(throwable.toString());
                                    getMvpView().hideProgressDialog();

                                }
                            }));
        } else {
            getMvpView().error("No Internet Connection");
        }
    }
}

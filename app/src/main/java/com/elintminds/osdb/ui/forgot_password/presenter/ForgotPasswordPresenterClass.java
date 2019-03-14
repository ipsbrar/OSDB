package com.elintminds.osdb.ui.forgot_password.presenter;

import android.content.Context;
import android.util.Log;
import com.elintminds.osdb.R;
import com.elintminds.osdb.data.app_prefs.AppPreferenceHelperClass;
import com.elintminds.osdb.ui.base.presenter.BasePresenterClass;
import com.elintminds.osdb.ui.forgot_password.ForgotPasswordBean;
import com.elintminds.osdb.ui.forgot_password.model.ForgotPasswordInteractor;
import com.elintminds.osdb.ui.forgot_password.model.ForgotPasswordInteractorClass;
import com.elintminds.osdb.ui.forgot_password.view.ForgotPasswordView;
import com.elintminds.osdb.ui.login.beans.UserBean;
import io.reactivex.functions.Consumer;

public class ForgotPasswordPresenterClass<V extends ForgotPasswordView, I extends ForgotPasswordInteractor> extends BasePresenterClass<V,I> implements ForgotPasswordPresenter<V,I>
{
    private ForgotPasswordPresenterClass(Context context, I interactor, V view) {
        super(context, interactor, view);
    }

    public ForgotPasswordPresenterClass(Context context, V view) {
        this(context, (I) new ForgotPasswordInteractorClass(new AppPreferenceHelperClass(context), context), view);
    }

    @Override
    public void getEmailToSendResetLink(String email,final Context context) {
        getMvpView().showProgressDialog();
        getCompositeDisposable().add(getInteractor()
                .getEmailResetLink(email)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<ForgotPasswordBean>() {
                               @Override
                               public void accept(ForgotPasswordBean forgotPasswordBean) throws Exception {
                                   Log.e("loginstatuspresenter", "Success=======");

                                   if (forgotPasswordBean.getError() != null){
                                       getMvpView().error(forgotPasswordBean.getError());

                                   }else{
                                       getMvpView().success(context.getString(R.string.forgot_password_link));
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
    }
}

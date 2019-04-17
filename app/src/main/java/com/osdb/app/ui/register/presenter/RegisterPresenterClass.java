package com.osdb.app.ui.register.presenter;

import android.content.Context;
import android.util.Log;
import com.osdb.app.data.app_prefs.AppPreferenceHelperClass;
import com.osdb.app.ui.base.presenter.BasePresenterClass;
import com.osdb.app.ui.register.beans.RegisterBean;
import com.osdb.app.ui.register.model.RegisterInteractor;
import com.osdb.app.ui.register.model.RegisterInteractorClass;
import com.osdb.app.ui.register.view.RegisterView;
import com.osdb.app.utils.ConnectivityReceiver;
import io.reactivex.functions.Consumer;

public class RegisterPresenterClass<V extends RegisterView, I extends RegisterInteractor> extends BasePresenterClass<V,I> implements RegisterPresenter<V,I>
{
    private RegisterPresenterClass(Context context, I interactor, V view) {
        super(context, interactor, view);
    }

    public RegisterPresenterClass(Context context, V view) {
        this(context, (I) new RegisterInteractorClass(new AppPreferenceHelperClass(context), context), view);
    }

    @Override
    public void getRegisterData(String name, String email, String password, String phoneNumber, String type) {
        if (ConnectivityReceiver.isConnected()){
        getMvpView().showProgressDialog();
        getCompositeDisposable().add(getInteractor()
                .doServerRegister(name, email, password, phoneNumber, type)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<RegisterBean>() {
                               @Override
                               public void accept(RegisterBean registerBean) throws Exception {
                                   Log.e("loginstatuspresenter","Success=======");
//                                   if (registerBean.getEmail() != null ) {
//                                       getMvpView().getError(registerBean.getEmailList().get(0));
//                                   }else{

//                                   }
                                   getMvpView().getSuccess(registerBean);
                                   getMvpView().hideProgressDialog();

                               }
                           },
                        new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception
                            {
                                Log.e("loginstatuspresenter","Error=======    "+   throwable.toString());
                                getMvpView().getError(throwable.toString());
                                getMvpView().hideProgressDialog();

                            }
                        }));

    }else{
            getMvpView().getError("No Internet Connection");
        }
    }
}


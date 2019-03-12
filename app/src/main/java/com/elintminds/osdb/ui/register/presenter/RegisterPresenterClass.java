package com.elintminds.osdb.ui.register.presenter;

import android.content.Context;
import android.util.Log;
import com.elintminds.osdb.data.app_prefs.AppPreferenceHelperClass;
import com.elintminds.osdb.ui.base.presenter.BasePresenterClass;
import com.elintminds.osdb.ui.login.beans.UserBean;
import com.elintminds.osdb.ui.register.beans.RegisterBean;
import com.elintminds.osdb.ui.register.model.RegisterInteractor;
import com.elintminds.osdb.ui.register.model.RegisterInteractorClass;
import com.elintminds.osdb.ui.register.view.RegisterView;
import io.reactivex.functions.Consumer;

import java.util.List;

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

    }
}


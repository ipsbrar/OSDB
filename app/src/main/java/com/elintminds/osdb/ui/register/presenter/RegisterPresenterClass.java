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
        getCompositeDisposable().add(getInteractor()
                .doServerRegister(name, email, password, phoneNumber, type)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<RegisterBean>() {
                               @Override
                               public void accept(RegisterBean registerBean) throws Exception {
                                   Log.e("loginstatuspresenter","Success=======");
                                   getMvpView().getSuccess(registerBean);
//                                       LoginResponseBean response = loginBean.getResponse();
//                                       if (response.getStatus().equals(WebserviceUrls.STATUSONE))
//                                       {
//                                           // saving user credentials in app preferences
//                                           LoginDataBean data = response.getData();
//
//                                           if(data.getTypeOfUser().equals("1")) {
//                                               getSeekerUserDetails(data.getAccessKey());
//                                           }else if(data.getTypeOfUser().equals("2")){
//                                               getProviderUserDetails(data.getAccessKey());
//                                           }
//
//                                       } else {
//                                           getMvpView().hideDialog();
//                                           getMvpView().showError(response.getMessage());
//                                       }

                               }
                           },
                        new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception
                            {
                                Log.e("loginstatuspresenter","Error=======    "+   throwable.toString());
                                getMvpView().getError(throwable.toString());
//                                    getMvpView().hideDialog();
//                                    getMvpView().showErrorToast(context.getString(R.string.some_error));
//                                    Log.e("LOGIN ERROR",""+throwable.toString());
                            }
                        }));

    }
}


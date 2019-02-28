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
import io.reactivex.functions.Consumer;

public class LoginPresenterClass<V extends LoginView, I extends LoginInteractor> extends BasePresenterClass<V, I> implements LoginPresenter<V, I> {

    private Context context;
    private LoginPresenterClass(Context context, I interactor, V view) {
        super(context, interactor, view);
    }

    public LoginPresenterClass(Context context, V view) {
        this(context, (I) new LoginInteractorClass(new AppPreferenceHelperClass(context), context), view);
        this.context=context;
    }


    @Override
    public void sendUserValue(String userEmail, String userPassword) {
//        getInteractor().userValuesFromPresenter(userName,userPassword);

//        if (WebserviceUrls.isInternetIsAvailable(context))
//        {
//            Bundle args = new Bundle();
//            args.putString("PROGRESS_TITLE", context.getString(R.string.signing_in));
//            getMvpView().showDialog(LoginProgressDialog.newInstance(args));

            getCompositeDisposable().add(getInteractor()
                    .doServerLogin(userEmail, userPassword)
                    .subscribeOn(getSchedulerProvider().io())
                    .observeOn(getSchedulerProvider().ui())
                    .subscribe(new Consumer<UserBean>() {
                                   @Override
                                   public void accept(UserBean loginBean) throws Exception {
                                       Log.e("loginstatuspresenter","Success=======");
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
//                                    getMvpView().hideDialog();
//                                    getMvpView().showErrorToast(context.getString(R.string.some_error));
//                                    Log.e("LOGIN ERROR",""+throwable.toString());
                                }
                            }));

        }
//        else {
////            getMvpView().showNoInternetScreen();
//            Toast.makeText(context, "No Internet Connection", Toast.LENGTH_SHORT).show();
//        }
//    }

    @Override
    public void onSuccess(String Result) {

    }

    @Override
    public void onError(String Error) {

    }
}

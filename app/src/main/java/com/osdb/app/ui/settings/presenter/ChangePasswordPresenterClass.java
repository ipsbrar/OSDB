package com.osdb.app.ui.settings.presenter;

import android.content.Context;
import android.util.Log;
import com.osdb.app.data.app_prefs.AppPreferenceHelperClass;
import com.osdb.app.ui.base.presenter.BasePresenterClass;
import com.osdb.app.ui.settings.model.ChangePasswordInteractor;
import com.osdb.app.ui.settings.model.ChangePasswordInteractorClass;
import com.osdb.app.ui.settings.view.ChangePasswordView;
import com.osdb.app.utils.ConnectivityReceiver;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;
import retrofit2.Response;

public class ChangePasswordPresenterClass<V extends ChangePasswordView, I extends ChangePasswordInteractor>
        extends BasePresenterClass<V, I> implements ChangePasswordPresenter<V, I> {
    public ChangePasswordPresenterClass(Context context, I interactor, V view) {
        super(context, interactor, view);
    }

    public ChangePasswordPresenterClass(Context context, V view) {
        this(context, (I) new ChangePasswordInteractorClass(new AppPreferenceHelperClass(context), context), view);
    }

    @Override
    public void getUserDetails(String id, String oldPassword, String password, String confirmPassword) {
        if (ConnectivityReceiver.isConnected()) {
            getMvpView().showProgressDialog();
            getCompositeDisposable().add(getInteractor()
                    .ChangePassword(id, oldPassword, password, confirmPassword)
                    .subscribeOn(getSchedulerProvider().io())
                    .observeOn(getSchedulerProvider().ui())
                    .subscribe(new Consumer<Response<JSONObject>>() {
                                   @Override
                                   public void accept(Response<JSONObject> response) throws Exception {
                                       Log.e("loginstatuspresenter", "Success=======");
                                       if (response.isSuccessful()) {
                                           getMvpView().success("Your password updated successfully");
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
            getMvpView().error("Check your internet connection");
        }
    }
}


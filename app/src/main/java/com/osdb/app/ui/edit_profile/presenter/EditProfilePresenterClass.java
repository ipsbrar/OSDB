package com.osdb.app.ui.edit_profile.presenter;

import android.content.Context;
import android.util.Log;
import com.google.gson.JsonElement;
import com.osdb.app.R;
import com.osdb.app.data.app_prefs.AppPreferenceHelperClass;
import com.osdb.app.ui.base.presenter.BasePresenterClass;
import com.osdb.app.ui.base.view.BaseView;
import com.osdb.app.ui.edit_profile.model.EditProfileInteractor;
import com.osdb.app.ui.edit_profile.model.EditProfileInteractorClass;
import com.osdb.app.ui.edit_profile.view.EditProfileView;
import com.osdb.app.ui.forgot_password.ForgotPasswordBean;
import com.osdb.app.utils.ConnectivityReceiver;
import io.reactivex.functions.Consumer;
import retrofit2.Response;

public class EditProfilePresenterClass<V extends EditProfileView, I extends EditProfileInteractor>
        extends BasePresenterClass<V, I> implements EditProfilePresenter<V, I> {
    private EditProfilePresenterClass(Context context, I interactor, V view) {
        super(context, interactor, view);
    }

    public EditProfilePresenterClass(Context context, V view) {
        this(context, (I) new EditProfileInteractorClass(new AppPreferenceHelperClass(context), context), view);
    }

    @Override
    public void updateUserValue(String name, String phoneNumber, String filePath) {
        if (ConnectivityReceiver.isConnected()) {
            getMvpView().showProgressDialog();
            getCompositeDisposable().add(getInteractor()
                    .updateUserValue(name, phoneNumber, filePath)
                    .subscribeOn(getSchedulerProvider().io())
                    .observeOn(getSchedulerProvider().ui())
                    .subscribe(new Consumer<Response<JsonElement>>() {
                                   @Override
                                   public void accept(Response<JsonElement> jsonElementResponse) throws Exception {
                                       Log.e("loginstatuspresenter", "Success=======");
                                       if (jsonElementResponse.isSuccessful()) {
                                           getMvpView().updateUserResult(jsonElementResponse.body().toString());
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

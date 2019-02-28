package com.elintminds.osdb.ui.dashboard.presenter;

import android.content.Context;
import android.util.Log;
import com.elintminds.osdb.data.app_prefs.AppPreferenceHelperClass;
import com.elintminds.osdb.ui.base.presenter.BasePresenterClass;
import com.elintminds.osdb.ui.dashboard.beans.SportsAdapterListBean;
import com.elintminds.osdb.ui.dashboard.model.LiveScroresInteractor;
import com.elintminds.osdb.ui.dashboard.model.LiveScroresInteractorClass;
import com.elintminds.osdb.ui.dashboard.view.LiveScroresView;
import io.reactivex.functions.Consumer;

import java.util.ArrayList;

public class LiveScroresPresenterClass<V extends LiveScroresView, I extends LiveScroresInteractor> extends BasePresenterClass<V,I> implements LiveScroresPresenter<V,I>
{
    private LiveScroresPresenterClass(Context context, I interactor, V view) {
        super(context, interactor, view);
    }

    public LiveScroresPresenterClass(Context context, V view) {
        this(context, (I) new LiveScroresInteractorClass(new AppPreferenceHelperClass(context), context), view);
    }

    @Override
    public void getSportsData() {
        getCompositeDisposable().add(getInteractor()
                .getAllSportsList()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<ArrayList<SportsAdapterListBean>>() {
                               @Override
                               public void accept(ArrayList<SportsAdapterListBean> sportsList) throws Exception {
                                   Log.e("SportsData","Success======="+   sportsList.get(0).getName());
                                   getMvpView().getSportsData(sportsList);
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
                                Log.e("SportsData","Error=======    "+   throwable.toString());
                                getMvpView().getError(throwable.toString());
//                                    getMvpView().hideDialog();
//                                    getMvpView().showErrorToast(context.getString(R.string.some_error));
//                                    Log.e("LOGIN ERROR",""+throwable.toString());
                            }
                        }));

    }
}

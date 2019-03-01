package com.elintminds.osdb.ui.dashboard.presenter;

import android.content.Context;
import android.util.Log;
import com.elintminds.osdb.data.app_prefs.AppPreferenceHelperClass;
import com.elintminds.osdb.ui.base.presenter.BasePresenterClass;
import com.elintminds.osdb.ui.dashboard.beans.BornTodayAdapterBean;
import com.elintminds.osdb.ui.dashboard.beans.SportsAdapterListBean;
import com.elintminds.osdb.ui.dashboard.model.HomeFragmentInteractor;
import com.elintminds.osdb.ui.dashboard.model.HomeFragmentInteractorClass;
import com.elintminds.osdb.ui.dashboard.view.HomeFragmentView;
import com.elintminds.osdb.ui.login.beans.UserBean;
import io.reactivex.functions.Consumer;

import java.util.ArrayList;

public class HomeFragmentPresenterClass<V extends HomeFragmentView, I extends HomeFragmentInteractor>
        extends BasePresenterClass< V, I> implements HomeFragmentPresenter<V, I>{


    private HomeFragmentPresenterClass(Context context, I interactor, V view) {
        super(context, interactor, view);
    }

    public HomeFragmentPresenterClass(Context context, V view) {
        this(context, (I) new HomeFragmentInteractorClass(new AppPreferenceHelperClass(context), context), view);
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


    @Override
    public void getHomeData() {

    }

    @Override
    public void getBornTodayData(String currentDate, String limit)
    {
        getCompositeDisposable().add(getInteractor()
                .getBornTodayList(currentDate, limit)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<ArrayList<BornTodayAdapterBean>>()
                           {
                               @Override
                               public void accept(ArrayList<BornTodayAdapterBean> sportsList) throws Exception {
                                   getMvpView().getBornTodayData(sportsList);
                               }
                           },
                        new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception
                            {
                                getMvpView().getError(throwable.toString());
                            }
                        }));
    }
}

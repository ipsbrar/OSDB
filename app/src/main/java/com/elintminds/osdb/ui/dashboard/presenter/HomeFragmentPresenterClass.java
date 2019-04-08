package com.elintminds.osdb.ui.dashboard.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.elintminds.osdb.data.app_prefs.AppPreferenceHelperClass;
import com.elintminds.osdb.data.network.WebserviceUrls;
import com.elintminds.osdb.ui.base.presenter.BasePresenterClass;
import com.elintminds.osdb.ui.dashboard.beans.*;
import com.elintminds.osdb.ui.dashboard.model.HomeFragmentInteractor;
import com.elintminds.osdb.ui.dashboard.model.HomeFragmentInteractorClass;
import com.elintminds.osdb.ui.dashboard.view.HomeFragmentView;
import com.elintminds.osdb.ui.login.beans.UserBean;
import com.elintminds.osdb.utils.ConnectivityReceiver;
import com.google.gson.JsonElement;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.HashMap;

public class HomeFragmentPresenterClass<V extends HomeFragmentView, I extends HomeFragmentInteractor>
        extends BasePresenterClass<V, I> implements HomeFragmentPresenter<V, I> {


    private HomeFragmentPresenterClass(Context context, I interactor, V view) {
        super(context, interactor, view);
    }

    public HomeFragmentPresenterClass(Context context, V view) {
        this(context, (I) new HomeFragmentInteractorClass(new AppPreferenceHelperClass(context), context), view);
    }

//    @Override
//    public void getSportsData() {
//        getCompositeDisposable().add(getInteractor()
//                .getAllSportsList()
//                .subscribeOn(getSchedulerProvider().io())
//                .observeOn(getSchedulerProvider().ui())
//                .subscribe(new Consumer<ArrayList<SportsAdapterListBean>>() {
//                               @Override
//                               public void accept(ArrayList<SportsAdapterListBean> sportsList) throws Exception {
//                                   Log.e("SportsData","Success======="+   sportsList.get(0).getName());
//                                   getMvpView().getSportsData(sportsList);
//                               }
//                           },
//                        new Consumer<Throwable>() {
//                            @Override
//                            public void accept(Throwable throwable) throws Exception
//                            {
//                                Log.e("SportsData","Error=======    "+   throwable.toString());
//                                getMvpView().getError(throwable.toString());
//                            }
//                        }));
//
//    }


    @Override
    public void getHomeData(String currentDate) {
        if (ConnectivityReceiver.isConnected()) {
            getCompositeDisposable().add(getInteractor()
                    .getAllHomeList(currentDate)
                    .subscribeOn(getSchedulerProvider().io())
                    .observeOn(getSchedulerProvider().ui())
                    .subscribe(new Consumer<HomeBean>() {
                                   @Override
                                   public void accept(HomeBean homeData) throws Exception {
                                       Log.e("HomeSwipeData", "   Inside Success");
                                       getMvpView().getHomesData(homeData);
                                   }
                               },
                            new Consumer<Throwable>() {
                                @Override
                                public void accept(Throwable throwable) throws Exception {
                                    Log.e("HomeSwipeData", "   Inside Reject");
                                    getMvpView().getError(throwable.toString());
                                }
                            }));
        }else{
            getMvpView().getError("No Internet connection");
        }
    }

    @Override
    public void AddVote(final Context context,String pollID, String optionID) {
        if (ConnectivityReceiver.isConnected()) {
            getMvpView().showProgressDialog();
            getCompositeDisposable().add(getInteractor()
                    .AddPollsComment(pollID, optionID)
                    .subscribeOn(getSchedulerProvider().io())
                    .observeOn(getSchedulerProvider().ui())
                    .subscribe(new Consumer<Response<JsonElement>>() {
                                   @Override
                                   public void accept(Response<JsonElement> response) throws Exception {
                                       if (response.isSuccessful()) {
                                           getMvpView().AddVotePollsSuccess(response.body().toString());
                                       } else {
                                           if (response.code() == 409) {
                                               Toast.makeText(context, "User already voted", Toast.LENGTH_SHORT).show();
                                           }
//                                           getMvpView().error(response.body().getString("error"), false);
                                       }
                                       getMvpView().hideProgressDialog();
                                   }
                               },
                            new Consumer<Throwable>() {
                                @Override
                                public void accept(Throwable throwable) throws Exception {
                                    Log.e("PollData", "Error=======    " + throwable.toString());
//                                    getMvpView().getError(throwable.toString());
                                    Toast.makeText(context, throwable.toString(), Toast.LENGTH_SHORT).show();
                                    getMvpView().hideProgressDialog();
                                }
                            }));

        } else {

            getMvpView().getError("No internet found");
        }
    }

//    @Override
//    public void getBornTodayData(String currentDate, String limit)
//    {
//        getCompositeDisposable().add(getInteractor()
//                .getBornTodayList(currentDate, limit)
//                .subscribeOn(getSchedulerProvider().io())
//                .observeOn(getSchedulerProvider().ui())
//                .subscribe(new Consumer<ArrayList<BornTodayAdapterBean>>()
//                           {
//                               @Override
//                               public void accept(ArrayList<BornTodayAdapterBean> sportsList) throws Exception {
////                                   getMvpView().getBornTodayData(sportsList);
//                               }
//                           },
//                        new Consumer<Throwable>() {
//                            @Override
//                            public void accept(Throwable throwable) throws Exception
//                            {
//                                getMvpView().getError(throwable.toString());
//                            }
//                        }));
//    }
//
//    @Override
//    public void getBreakingNewsData() {
//        getCompositeDisposable().add(getInteractor()
//                .getAllNewsList()
//                .subscribeOn(getSchedulerProvider().io())
//                .observeOn(getSchedulerProvider().ui())
//                .subscribe(new Consumer<NewsAdapterBean>() {
//                               @Override
//                               public void accept(NewsAdapterBean newsList) throws Exception {
//                                   Log.e("NewsData","Success======="+   newsList.getData().size());
//                                    getMvpView().getBreakingNews(newsList.getBreakingNews());
//                               }
//                           },
//                        new Consumer<Throwable>() {
//                            @Override
//                            public void accept(Throwable throwable) throws Exception
//                            {
//                                Log.e("NewsData","Error=======    "+   throwable.toString());
//                                getMvpView().getError(throwable.toString());
//                            }
//                        }));
//    }
//
//    @Override
//    public void getDoYouKnow() {
//        getCompositeDisposable().add(getInteractor()
//                .getDoYouKnow()
//                .subscribeOn(getSchedulerProvider().io())
//                .observeOn(getSchedulerProvider().ui())
//                .subscribe(new Consumer<ArrayList<DoYouKnow>>()
//                           {
//                               @Override
//                               public void accept(ArrayList<DoYouKnow> doYouKnows) throws Exception {
//                                   getMvpView().getDoYouKnow(doYouKnows);
//                               }
//                           },
//                        new Consumer<Throwable>() {
//                            @Override
//                            public void accept(Throwable throwable) throws Exception
//                            {
//                                getMvpView().getError(throwable.toString());
//                            }
//                        }));
//    }

}

package com.elintminds.osdb.ui.dashboard.presenter;

import android.content.Context;
import android.util.Log;
import com.elintminds.osdb.data.app_prefs.AppPreferenceHelperClass;
import com.elintminds.osdb.ui.base.presenter.BasePresenterClass;
import com.elintminds.osdb.ui.dashboard.beans.SportsAdapterListBean;
import com.elintminds.osdb.ui.dashboard.model.LiveScroresInteractor;
import com.elintminds.osdb.ui.dashboard.model.LiveScroresInteractorClass;
import com.elintminds.osdb.ui.dashboard.view.LiveScroresView;
import com.elintminds.osdb.utils.ConnectivityReceiver;
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
        if (ConnectivityReceiver.isConnected()){
        getMvpView().showProgressDialog();
        getCompositeDisposable().add(getInteractor()
                .getAllSportsList()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<ArrayList<SportsAdapterListBean>>() {
                               @Override
                               public void accept(ArrayList<SportsAdapterListBean> sportsList) throws Exception {
                                   Log.e("SportsData","Success======="+   sportsList.get(0).getName());
                                   getMvpView().getSportsData(sportsList);
                                   getMvpView().hideProgressDialog();
                               }
                           },
                        new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception
                            {
                                Log.e("SportsData","Error=======    "+   throwable.toString());
                                getMvpView().getError(throwable.toString());
                                getMvpView().hideProgressDialog();
                            }
                        }));

    }else{
            getMvpView().getError("No Internet Connection");
        }}
}

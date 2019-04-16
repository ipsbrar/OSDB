package com.osdb.pro.ui.dashboard.presenter;

import android.content.Context;
import android.util.Log;
import com.osdb.pro.data.app_prefs.AppPreferenceHelperClass;
import com.osdb.pro.ui.base.presenter.BasePresenterClass;
import com.osdb.pro.ui.dashboard.beans.NewsAdapterBean;
import com.osdb.pro.ui.dashboard.model.NewsFragmentInteractor;
import com.osdb.pro.ui.dashboard.model.NewsFragmentInteractorClass;
import com.osdb.pro.ui.dashboard.view.NewsFragmentView;
import com.osdb.pro.utils.ConnectivityReceiver;
import io.reactivex.functions.Consumer;

public class NewsFragmentPresenterClass<V extends NewsFragmentView, I extends NewsFragmentInteractor> extends BasePresenterClass<V, I> implements NewsFragmentPresenter<V, I> {


    private NewsFragmentPresenterClass(Context context, I interactor, V view) {
        super(context, interactor, view);
    }

    public NewsFragmentPresenterClass(Context context, V view) {
        this(context, (I) new NewsFragmentInteractorClass(new AppPreferenceHelperClass(context), context), view);
    }

    @Override
    public void getNewsData(int offset) {
        if (ConnectivityReceiver.isConnected()) {
            getCompositeDisposable().add(getInteractor()
                    .getAllNewsList(offset)
                    .subscribeOn(getSchedulerProvider().io())
                    .observeOn(getSchedulerProvider().ui())
                    .subscribe(new Consumer<NewsAdapterBean>() {
                                   @Override
                                   public void accept(NewsAdapterBean newsList) throws Exception {
                                       Log.e("NewsData", "Success=======" + newsList.getData().size());
                                       getMvpView().getNewsData(newsList);

                                   }
                               },
                            new Consumer<Throwable>() {
                                @Override
                                public void accept(Throwable throwable) throws Exception {
                                    Log.e("NewsData", "Error=======    " + throwable.toString());
                                    getMvpView().getError(throwable.toString());

                                }
                            }));
        } else {
            getMvpView().getError("No internet found");
        }
    }
}

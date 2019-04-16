package com.osdb.pro.ui.base.presenter;

import com.osdb.pro.ui.base.model.BaseInteractor;
import com.osdb.pro.ui.base.view.BaseView;
import com.osdb.pro.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;

public interface BasePresenter<V extends BaseView, I extends BaseInteractor>
{
    V getMvpView();
    I getInteractor();

    SchedulerProvider getSchedulerProvider();
    CompositeDisposable getCompositeDisposable();

    void onDetach();
}

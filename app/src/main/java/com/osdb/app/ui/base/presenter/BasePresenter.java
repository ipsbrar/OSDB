package com.osdb.app.ui.base.presenter;

import com.osdb.app.ui.base.model.BaseInteractor;
import com.osdb.app.ui.base.view.BaseView;
import com.osdb.app.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;

public interface BasePresenter<V extends BaseView, I extends BaseInteractor>
{
    V getMvpView();
    I getInteractor();

    SchedulerProvider getSchedulerProvider();
    CompositeDisposable getCompositeDisposable();

    void onDetach();
}

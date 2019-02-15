package com.elintminds.osdb.ui.base.presenter;

import com.elintminds.osdb.ui.base.model.BaseInteractor;
import com.elintminds.osdb.ui.base.view.BaseView;
import com.elintminds.osdb.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;

public interface BasePresenter<V extends BaseView, I extends BaseInteractor>
{
    V getMvpView();
    I getInteractor();

    SchedulerProvider getSchedulerProvider();
    CompositeDisposable getCompositeDisposable();

    void onDetach();
}

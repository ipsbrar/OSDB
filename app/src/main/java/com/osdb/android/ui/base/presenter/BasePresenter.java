package com.osdb.android.ui.base.presenter;

import com.osdb.android.ui.base.model.BaseInteractor;
import com.osdb.android.ui.base.view.BaseView;
import com.osdb.android.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;

public interface BasePresenter<V extends BaseView, I extends BaseInteractor>
{
    V getMvpView();
    I getInteractor();

    SchedulerProvider getSchedulerProvider();
    CompositeDisposable getCompositeDisposable();

    void onDetach();
}

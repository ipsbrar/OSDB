package com.osdb.pro.ui.base.presenter;

import android.content.Context;
import com.osdb.pro.ui.base.model.BaseInteractor;
import com.osdb.pro.ui.base.view.BaseView;
import com.osdb.pro.utils.rx.AppSchedulerProvider;
import com.osdb.pro.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;

public class BasePresenterClass<V extends BaseView, I extends BaseInteractor> implements BasePresenter<V,I>
{
    private I mMvpInterector;
    private V mMvpView;
    private CompositeDisposable compositeDisposable;
    private SchedulerProvider schedulerProvider;


    public BasePresenterClass(Context context,I interactor, V view)
    {
        this.mMvpInterector = interactor;
        this.mMvpView = view;
        compositeDisposable = new CompositeDisposable();
        schedulerProvider = new AppSchedulerProvider();
    }


    @Override
    public V getMvpView()
    {
        return mMvpView;
    }

    @Override
    public I getInteractor()
    {
        return mMvpInterector;
    }

    @Override
    public SchedulerProvider getSchedulerProvider()
    {
        return schedulerProvider;
    }

    @Override
    public CompositeDisposable getCompositeDisposable()
    {
        return compositeDisposable;
    }

    @Override
    public void onDetach()
    {
        mMvpView = null;
        mMvpInterector = null;
    }
}

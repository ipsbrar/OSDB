package com.elintminds.osdb.ui.splash.presenter

import android.content.Context
import com.elintminds.osdb.ui.base.presenter.BasePresenterClass
import com.elintminds.osdb.ui.splash.model.SplashInteractor
import com.elintminds.osdb.ui.splash.view.DoYouKnowView

class SplashPresenterClass<V : DoYouKnowView, I : SplashInteractor>
private constructor(context: Context, interactor: I, view: V) : BasePresenterClass<V, I>(context, interactor, view),
    SplashPresenter<V, I> {



}

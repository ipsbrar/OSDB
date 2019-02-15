package com.elintminds.osdb.ui.splash.presenter

import android.content.Context
import android.util.Log
import com.elintminds.osdb.ui.base.presenter.BasePresenterClass
import com.elintminds.osdb.ui.splash.model.SplashInteractor
import com.elintminds.osdb.ui.splash.presenter.SplashPresenter
import com.elintminds.osdb.ui.splash.view.SplashView

import com.google.gson.Gson

class SplashPresenterClass<V : SplashView, I : SplashInteractor>
private constructor(context: Context, interactor: I, view: V) : BasePresenterClass<V, I>(context, interactor, view),
    SplashPresenter<V, I> {



}

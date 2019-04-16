package com.osdb.pro.ui.splash.presenter


import com.osdb.pro.ui.base.presenter.BasePresenter

import com.osdb.pro.ui.splash.model.SplashInteractor
import com.osdb.pro.ui.splash.view.SplashView

interface SplashPresenter<V : SplashView, I : SplashInteractor> : BasePresenter<V, I> {


}
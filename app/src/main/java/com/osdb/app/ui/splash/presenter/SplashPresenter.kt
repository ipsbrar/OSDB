package com.osdb.app.ui.splash.presenter


import com.osdb.app.ui.base.presenter.BasePresenter

import com.osdb.app.ui.splash.model.SplashInteractor
import com.osdb.app.ui.splash.view.SplashView

interface SplashPresenter<V : SplashView, I : SplashInteractor> : BasePresenter<V, I> {


}
package com.osdb.android.ui.splash.presenter


import com.osdb.android.ui.base.presenter.BasePresenter

import com.osdb.android.ui.splash.model.SplashInteractor
import com.osdb.android.ui.splash.view.SplashView

interface SplashPresenter<V : SplashView, I : SplashInteractor> : BasePresenter<V, I> {


}
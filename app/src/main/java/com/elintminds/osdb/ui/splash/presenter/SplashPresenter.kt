package com.elintminds.osdb.ui.splash.presenter


import com.elintminds.osdb.ui.base.presenter.BasePresenter

import com.elintminds.osdb.ui.splash.model.SplashInteractor
import com.elintminds.osdb.ui.splash.view.DoYouKnowView

interface SplashPresenter<V : DoYouKnowView, I : SplashInteractor> : BasePresenter<V, I> {


}
package com.elintminds.osdb.ui.splash.presenter


import com.elintminds.osdb.ui.base.presenter.BasePresenter

import com.elintminds.osdb.ui.splash.model.SplashInteractor
import com.elintminds.osdb.ui.splash.view.DiscussionCommentsView
import com.elintminds.osdb.ui.splash.view.SplashView

interface SplashPresenter<V : SplashView, I : SplashInteractor> : BasePresenter<V, I> {


}
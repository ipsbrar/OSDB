package com.osdb.pro.ui.splash.presenter


import com.osdb.pro.ui.base.presenter.BasePresenter
import com.osdb.pro.ui.do_you_know.model.DiscussionCommentsInteractor
import com.osdb.pro.ui.splash.view.DiscussionCommentsView

interface DoYouKnowPresenter<V : DiscussionCommentsView, I : DiscussionCommentsInteractor> : BasePresenter<V, I> {


}
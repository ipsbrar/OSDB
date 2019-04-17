package com.osdb.app.ui.splash.presenter


import com.osdb.app.ui.base.presenter.BasePresenter
import com.osdb.app.ui.do_you_know.model.DiscussionCommentsInteractor
import com.osdb.app.ui.splash.view.DiscussionCommentsView

interface DiscussionCommentsPresenter<V : DiscussionCommentsView, I : DiscussionCommentsInteractor> : BasePresenter<V, I> {
     fun getDiscussion(id : String)
}